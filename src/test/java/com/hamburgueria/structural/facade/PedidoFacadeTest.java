package com.hamburgueria.structural.facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.estado.EstoqueSubsistema;
import com.hamburgueria.infra.CozinhaSubsistema;
import com.hamburgueria.infra.NotificacaoSubsistema;
import com.hamburgueria.infra.PagamentoSubsistema;
import com.hamburgueria.infra.PedidoFacade;

import static org.junit.jupiter.api.Assertions.*;

class PedidoFacadeTest {

    @Test
    @DisplayName("Fechar pedido com pagamento valido deve retornar true e orquestrar subsistemas")
    void deveFecharPedidoComSucesso() {
        PedidoFacade facade = new PedidoFacade();

        boolean resultado = facade.fecharPedido("Carne 120g", "X-Burguer", 15.90);

        assertTrue(resultado);
    }

    @Test
    @DisplayName("Fechar pedido com valor zero deve falhar no pagamento")
    void deveFalharComValorZero() {
        PedidoFacade facade = new PedidoFacade();

        boolean resultado = facade.fecharPedido("Carne 120g", "X-Burguer", 0.0);

        assertFalse(resultado);
    }

    @Test
    @DisplayName("Facade deve impedir fechamento quando estoque esta indisponivel")
    void deveImpedirFechamentoSemEstoque() {
        EstoqueSubsistema estoqueSemItem = new EstoqueSubsistema() {
            @Override
            public boolean verificarDisponibilidade(String ingrediente, int quantidade) {
                return false;
            }
        };
        PedidoFacade facade = new PedidoFacade(
                estoqueSemItem, new CozinhaSubsistema(), new PagamentoSubsistema(), new NotificacaoSubsistema());

        boolean resultado = facade.fecharPedido("Carne 120g", "X-Burguer", 15.90);

        assertFalse(resultado);
    }

    @Test
    @DisplayName("Cliente da facade nao precisa interagir diretamente com os subsistemas")
    void clienteNaoDeveInteragirComSubsistemasDiretamente() {
        PedidoFacade facade = new PedidoFacade();

        assertDoesNotThrow(() -> facade.fecharPedido("Frango", "X-Frango", 18.00));
    }
}
