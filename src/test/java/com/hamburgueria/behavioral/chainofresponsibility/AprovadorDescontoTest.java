package com.hamburgueria.behavioral.chainofresponsibility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.desconto.AprovadorDesconto;
import com.hamburgueria.desconto.CadeiaAprovacaoFactory;

import static org.junit.jupiter.api.Assertions.*;

class AprovadorDescontoTest {

    @Test
    @DisplayName("Atendente deve aprovar desconto dentro do proprio limite (10%)")
    void atendenteDeveAprovarDescontoBaixo() {
        AprovadorDesconto cadeia = CadeiaAprovacaoFactory.criarCadeiaPadrao();

        String resultado = cadeia.processar(0.05);

        assertTrue(resultado.contains("Atendente"));
    }

    @Test
    @DisplayName("Desconto acima do limite do atendente deve subir para o Supervisor")
    void deveSubirParaSupervisorQuandoAcimaDoLimiteDoAtendente() {
        AprovadorDesconto cadeia = CadeiaAprovacaoFactory.criarCadeiaPadrao();

        String resultado = cadeia.processar(0.20);

        assertTrue(resultado.contains("Supervisor"));
    }

    @Test
    @DisplayName("Desconto acima do limite do supervisor deve subir para o Gerente")
    void deveSubirParaGerenteQuandoAcimaDoLimiteDoSupervisor() {
        AprovadorDesconto cadeia = CadeiaAprovacaoFactory.criarCadeiaPadrao();

        String resultado = cadeia.processar(0.50);

        assertTrue(resultado.contains("Gerente"));
    }

    @Test
    @DisplayName("Gerente deve aprovar ate 100% de desconto")
    void gerenteDeveAprovarDescontoTotal() {
        AprovadorDesconto cadeia = CadeiaAprovacaoFactory.criarCadeiaPadrao();

        String resultado = cadeia.processar(1.0);

        assertTrue(resultado.contains("Gerente"));
        assertTrue(resultado.contains("aprovou"));
    }

    @Test
    @DisplayName("Solicitante nao deve precisar saber qual aprovador especifico tratou a solicitacao")
    void solicitanteNaoDeveConhecerAprovadorEspecifico() {
        AprovadorDesconto cadeia = CadeiaAprovacaoFactory.criarCadeiaPadrao();

        assertDoesNotThrow(() -> cadeia.processar(0.15));
    }
}
