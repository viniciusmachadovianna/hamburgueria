package com.hamburgueria.behavioral.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.pedido.PedidoComEstado;

import static org.junit.jupiter.api.Assertions.*;

class PedidoComEstadoTest {

    @Test
    @DisplayName("Pedido deve iniciar no estado RECEBIDO")
    void deveIniciarComoRecebido() {
        assertEquals("RECEBIDO", new PedidoComEstado().getEstadoAtual());
    }

    @Test
    @DisplayName("Ciclo completo: RECEBIDO -> EM_PREPARO -> PRONTO -> ENTREGUE")
    void devePeercorrerCicloCompleto() {
        PedidoComEstado pedido = new PedidoComEstado();

        pedido.avancar();
        assertEquals("EM_PREPARO", pedido.getEstadoAtual());

        pedido.avancar();
        assertEquals("PRONTO", pedido.getEstadoAtual());

        pedido.avancar();
        assertEquals("ENTREGUE", pedido.getEstadoAtual());
    }

    @Test
    @DisplayName("Cancelar em RECEBIDO deve ir para CANCELADO")
    void deveCancelarDeRecebido() {
        PedidoComEstado pedido = new PedidoComEstado();

        pedido.cancelar();

        assertEquals("CANCELADO", pedido.getEstadoAtual());
    }

    @Test
    @DisplayName("Avancar apos ENTREGUE deve lancar excecao")
    void avancarAposEntregueDeveLancarExcecao() {
        PedidoComEstado pedido = new PedidoComEstado();
        pedido.avancar(); pedido.avancar(); pedido.avancar();

        assertThrows(IllegalStateException.class, pedido::avancar);
    }

    @Test
    @DisplayName("Cancelar pedido PRONTO deve lancar excecao")
    void cancelarPedidoProntoDeveLancarExcecao() {
        PedidoComEstado pedido = new PedidoComEstado();
        pedido.avancar(); pedido.avancar();

        assertThrows(IllegalStateException.class, pedido::cancelar);
    }
}
