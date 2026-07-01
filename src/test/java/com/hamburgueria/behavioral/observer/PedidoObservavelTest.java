package com.hamburgueria.behavioral.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.notificacao.AppNotificacao;
import com.hamburgueria.notificacao.DisplaySenha;
import com.hamburgueria.notificacao.PainelCozinha;
import com.hamburgueria.pedido.PedidoObservavel;

import static org.junit.jupiter.api.Assertions.*;

class PedidoObservavelTest {

    private PedidoObservavel pedido;
    private PainelCozinha painel;
    private DisplaySenha display;
    private AppNotificacao app;

    @BeforeEach
    void setUp() {
        pedido  = new PedidoObservavel(42);
        painel  = new PainelCozinha();
        display = new DisplaySenha();
        app     = new AppNotificacao();
    }

    @Test
    @DisplayName("Mudanca de status deve notificar todos os observadores inscritos")
    void devNotificarTodosAoMudarStatus() {
        pedido.inscrever(painel);
        pedido.inscrever(display);
        pedido.inscrever(app);

        pedido.mudarStatus("EM_PREPARO");

        assertEquals("EM_PREPARO", painel.getUltimoStatus());
        assertEquals("EM_PREPARO", display.getUltimoStatus());
        assertEquals("EM_PREPARO", app.getUltimoStatus());
    }

    @Test
    @DisplayName("Observador desinscrito nao deve receber notificacoes")
    void observadorDesinscritoNaoDeveSerNotificado() {
        pedido.inscrever(painel);
        pedido.inscrever(app);
        pedido.desinscrever(app);

        pedido.mudarStatus("PRONTO");

        assertEquals("PRONTO", painel.getUltimoStatus());
        assertEquals("", app.getUltimoStatus());
    }

    @Test
    @DisplayName("Multiplas mudancas de status devem propagar corretamente")
    void multiplasMudancasDevemPropagarCorretamente() {
        pedido.inscrever(painel);

        pedido.mudarStatus("EM_PREPARO");
        pedido.mudarStatus("PRONTO");
        pedido.mudarStatus("ENTREGUE");

        assertEquals("ENTREGUE", painel.getUltimoStatus());
        assertEquals("ENTREGUE", pedido.getStatusAtual());
    }

    @Test
    @DisplayName("Pedido sem observadores nao deve lancar excecao ao mudar status")
    void semObservadoresNaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> pedido.mudarStatus("EM_PREPARO"));
    }
}
