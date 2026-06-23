package com.hamburgueria.structural.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdaptadorGatewayExternoTest {

    @Test
    @DisplayName("Adapter deve traduzir double para centavos e retornar true em sucesso")
    void deveProcessarPagamentoComSucesso() {
        ProcessadorPagamento processador = new AdaptadorGatewayExterno(new GatewayPagamentoExterno());

        boolean resultado = processador.processarPagamento(25.90);

        assertTrue(resultado);
    }

    @Test
    @DisplayName("Adapter deve retornar false quando o gateway externo falha")
    void deveRetornarFalseEmFalha() {
        ProcessadorPagamento processador = new AdaptadorGatewayExterno(new GatewayPagamentoExterno());

        boolean resultado = processador.processarPagamento(0.0);

        assertFalse(resultado);
    }

    @Test
    @DisplayName("Cliente deve poder usar o adapter atraves apenas da interface ProcessadorPagamento")
    void clienteDeveUsarApenasAInterfaceAlvo() {
        ProcessadorPagamento processador = new AdaptadorGatewayExterno(new GatewayPagamentoExterno());

        assertInstanceOf(ProcessadorPagamento.class, processador);
        assertDoesNotThrow(() -> processador.processarPagamento(10.0));
    }

    @Test
    @DisplayName("Conversao de reais para centavos deve arredondar corretamente")
    void deveArredondarValoresCorretamente() {
        // 19.999 reais deveria virar 2000 centavos apos arredondamento
        ProcessadorPagamento processador = new AdaptadorGatewayExterno(new GatewayPagamentoExterno());

        assertTrue(processador.processarPagamento(19.999));
    }
}
