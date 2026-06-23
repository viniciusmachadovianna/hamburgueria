package com.hamburgueria.behavioral.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentralAtendimentoTest {

    private CentralAtendimento central;
    private Cozinha cozinha;
    private Caixa caixa;
    private Entregador entregador;

    @BeforeEach
    void setUp() {
        central    = new CentralAtendimento();
        cozinha    = new Cozinha(central);
        caixa      = new Caixa(central);
        entregador = new Entregador(central);
        central.setCozinha(cozinha);
        central.setCaixa(caixa);
        central.setEntregador(entregador);
    }

    @Test
    @DisplayName("Caixa registrando pedido deve notificar a Cozinha via mediador")
    void caixaRegistrandoDeveComunicarCozinha() {
        caixa.registrarPedido();

        assertEquals("NOVO_PEDIDO", cozinha.getUltimoEvento());
    }

    @Test
    @DisplayName("Cozinha sinalizando pedido pronto deve notificar Caixa e Entregador")
    void cozinhaProntaDeveNotificarCaixaEEntregador() {
        cozinha.pedidoPronto();

        assertEquals("PEDIDO_PRONTO", caixa.getUltimoEvento());
        assertEquals("PEDIDO_PRONTO", entregador.getUltimoEvento());
    }

    @Test
    @DisplayName("Estacoes nao devem referenciar umas as outras diretamente")
    void estacoesNaoDevemSeConhecerDiretamente() {
        assertInstanceOf(AtendimentoMediator.class, central);
        assertDoesNotThrow(() -> caixa.registrarPedido());
    }
}
