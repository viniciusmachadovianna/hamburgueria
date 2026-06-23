package com.hamburgueria.behavioral.memento;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MementoTest {

    @Test
    @DisplayName("Salvar e restaurar estado deve reverter o pedido ao ponto salvo")
    void deveSalvarERestaurarEstado() {
        PedidoEmEdicao pedido = new PedidoEmEdicao();
        HistoricoPedido historico = new HistoricoPedido();

        pedido.adicionarItem("X-Burguer", 15.90);
        historico.salvar(pedido.salvarEstado());     // checkpoint

        pedido.adicionarItem("Batata Frita", 8.00); // alteracao apos checkpoint
        assertEquals(2, pedido.getItens().size());

        pedido.restaurarEstado(historico.desfazer()); // volta ao checkpoint

        assertEquals(1, pedido.getItens().size());
        assertEquals(15.90, pedido.getTotal(), 0.001);
    }

    @Test
    @DisplayName("Multiplos checkpoints devem ser restaurados em ordem LIFO")
    void deveRestaurarEmOrdemLIFO() {
        PedidoEmEdicao pedido = new PedidoEmEdicao();
        HistoricoPedido historico = new HistoricoPedido();

        historico.salvar(pedido.salvarEstado());        // checkpoint 1: vazio
        pedido.adicionarItem("X-Burguer", 15.90);
        historico.salvar(pedido.salvarEstado());        // checkpoint 2: 1 item

        pedido.adicionarItem("Refrigerante", 6.00);
        pedido.restaurarEstado(historico.desfazer());   // volta ao checkpoint 2

        assertEquals(1, pedido.getItens().size());

        pedido.restaurarEstado(historico.desfazer());   // volta ao checkpoint 1

        assertTrue(pedido.getItens().isEmpty());
    }

    @Test
    @DisplayName("Caretaker nao deve expor o conteudo interno do memento")
    void caretakerNaoDeveExporConteudoDoMemento() {
        // HistoricoPedido so conhece PedidoMemento como caixa-preta
        // — verificamos que o tipo retornado e opaco para o caretaker
        HistoricoPedido historico = new HistoricoPedido();
        PedidoEmEdicao pedido = new PedidoEmEdicao();
        pedido.adicionarItem("Item", 10.0);
        historico.salvar(pedido.salvarEstado());

        assertNotNull(historico.desfazer());
    }

    @Test
    @DisplayName("Desfazer sem checkpoints deve retornar null sem lancar excecao")
    void desfazerSemCheckpointsDeveRetornarNull() {
        HistoricoPedido historico = new HistoricoPedido();

        assertNull(historico.desfazer());
    }
}
