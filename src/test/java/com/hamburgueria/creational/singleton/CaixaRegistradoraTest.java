package com.hamburgueria.creational.singleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaixaRegistradoraTest {

    @AfterEach
    void tearDown() {
        CaixaRegistradora.getInstance().resetar();
    }

    @Test
    @DisplayName("getInstance() deve sempre retornar a mesma instancia")
    void deveRetornarSempreAMesmaInstancia() {
        CaixaRegistradora c1 = CaixaRegistradora.getInstance();
        CaixaRegistradora c2 = CaixaRegistradora.getInstance();

        assertSame(c1, c2, "As duas referencias devem apontar para o mesmo objeto");
    }

    @Test
    @DisplayName("Registrar venda deve aumentar saldo e contagem de vendas")
    void deveRegistrarVendaCorretamente() {
        CaixaRegistradora caixa = CaixaRegistradora.getInstance();

        caixa.registrarVenda(25.90);
        caixa.registrarVenda(14.50);

        assertEquals(40.40, caixa.getSaldoEmCaixa(), 0.001);
        assertEquals(2, caixa.getTotalVendasRegistradas());
    }

    @Test
    @DisplayName("Estado deve ser compartilhado entre diferentes pontos de acesso")
    void estadoDeveSerCompartilhadoGlobalmente() {
        CaixaRegistradora.getInstance().registrarVenda(100.0);

        // Simula outro ponto do sistema acessando a mesma instancia
        CaixaRegistradora outraReferencia = CaixaRegistradora.getInstance();

        assertEquals(100.0, outraReferencia.getSaldoEmCaixa(), 0.001);
    }

    @Test
    @DisplayName("Registrar venda com valor negativo deve lancar excecao")
    void deveLancarExcecaoParaValorNegativo() {
        CaixaRegistradora caixa = CaixaRegistradora.getInstance();

        assertThrows(IllegalArgumentException.class, () -> caixa.registrarVenda(-10.0));
    }

    @Test
    @DisplayName("Sangria deve reduzir o saldo em caixa")
    void deveRealizarSangriaCorretamente() {
        CaixaRegistradora caixa = CaixaRegistradora.getInstance();
        caixa.registrarVenda(200.0);

        caixa.registrarSangria(50.0);

        assertEquals(150.0, caixa.getSaldoEmCaixa(), 0.001);
    }
}
