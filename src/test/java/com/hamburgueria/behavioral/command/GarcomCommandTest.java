package com.hamburgueria.behavioral.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.atendimento.Garcom;
import com.hamburgueria.pedido.Pedido;
import com.hamburgueria.pedido.comando.AdicionarItemCommand;
import com.hamburgueria.pedido.comando.RemoverItemCommand;

import static org.junit.jupiter.api.Assertions.*;

class GarcomCommandTest {

    @Test
    @DisplayName("Executar AdicionarItemCommand deve adicionar item ao pedido")
    void deveAdicionarItemAoExecutarComando() {
        Pedido pedido = new Pedido();
        Garcom garcom = new Garcom();

        garcom.executarComando(new AdicionarItemCommand(pedido, "X-Burguer"));

        assertTrue(pedido.getItens().contains("X-Burguer"));
    }

    @Test
    @DisplayName("Desfazer deve reverter a ultima acao executada")
    void desfazerDeveReverterUltimaAcao() {
        Pedido pedido = new Pedido();
        Garcom garcom = new Garcom();
        garcom.executarComando(new AdicionarItemCommand(pedido, "X-Salada"));

        garcom.desfazerUltimo();

        assertFalse(pedido.getItens().contains("X-Salada"));
    }

    @Test
    @DisplayName("RemoverItemCommand desfeito deve devolver o item ao pedido")
    void removerItemDesfeitoDeveDevolverItem() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem("Batata Frita");
        Garcom garcom = new Garcom();
        garcom.executarComando(new RemoverItemCommand(pedido, "Batata Frita"));
        assertFalse(pedido.getItens().contains("Batata Frita"));

        garcom.desfazerUltimo();

        assertTrue(pedido.getItens().contains("Batata Frita"));
    }

    @Test
    @DisplayName("Multiplos comandos devem ser desfeitos na ordem inversa (LIFO)")
    void multiplosComandosDevemSerDesfeitosEmOrdemInversa() {
        Pedido pedido = new Pedido();
        Garcom garcom = new Garcom();
        garcom.executarComando(new AdicionarItemCommand(pedido, "Item A"));
        garcom.executarComando(new AdicionarItemCommand(pedido, "Item B"));

        garcom.desfazerUltimo();

        assertTrue(pedido.getItens().contains("Item A"));
        assertFalse(pedido.getItens().contains("Item B"));
    }

    @Test
    @DisplayName("Historico deve refletir a quantidade de comandos executados")
    void historicoDeveRefletirQuantidadeDeComandos() {
        Pedido pedido = new Pedido();
        Garcom garcom = new Garcom();

        garcom.executarComando(new AdicionarItemCommand(pedido, "Item 1"));
        garcom.executarComando(new AdicionarItemCommand(pedido, "Item 2"));

        assertEquals(2, garcom.quantidadeComandosNoHistorico());
    }

    @Test
    @DisplayName("Desfazer sem nenhum comando no historico nao deve lancar excecao")
    void desfazerSemHistoricoNaoDeveLancarExcecao() {
        Garcom garcom = new Garcom();

        assertDoesNotThrow(garcom::desfazerUltimo);
    }
}
