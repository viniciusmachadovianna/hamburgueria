package com.hamburgueria.behavioral.interpreter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.desconto.CupomInterpretadorContexto;
import com.hamburgueria.desconto.ExpressaoCupom;

import static org.junit.jupiter.api.Assertions.*;

class CupomInterpretadorTest {

    private final CupomInterpretadorContexto contexto = new CupomInterpretadorContexto();

    @Test
    @DisplayName("Cupom '10PORCENTO' deve aplicar 10% de desconto sobre o valor do pedido")
    void deveInterpretarDescontoPercentual() {
        ExpressaoCupom expressao = contexto.interpretarCodigo("10PORCENTO");

        assertEquals(45.00, expressao.interpretar(50.00), 0.001);
    }

    @Test
    @DisplayName("Cupom 'FRETEGRATIS' deve abater o valor padrao de frete")
    void deveInterpretarFreteGratisPadrao() {
        ExpressaoCupom expressao = contexto.interpretarCodigo("FRETEGRATIS");

        assertEquals(42.00, expressao.interpretar(50.00), 0.001);
    }

    @Test
    @DisplayName("Cupom 'FRETEGRATIS12' deve abater frete de R$12 do pedido")
    void deveInterpretarFreteGratisComValorCustom() {
        ExpressaoCupom expressao = contexto.interpretarCodigo("FRETEGRATIS12");

        assertEquals(38.00, expressao.interpretar(50.00), 0.001);
    }

    @Test
    @DisplayName("Cupom nao reconhecido deve lancar IllegalArgumentException")
    void deveRejeitarCupomDesconhecido() {
        assertThrows(IllegalArgumentException.class,
                () -> contexto.interpretarCodigo("CUPOMINVALIDO"));
    }

    @Test
    @DisplayName("Cupom nulo ou vazio deve lancar IllegalArgumentException")
    void deveRejeitarCupomVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> contexto.interpretarCodigo(""));
    }

    @Test
    @DisplayName("Frete gratis nao deve gerar valor negativo quando frete supera o pedido")
    void freteGratisNaoDeveGerarValorNegativo() {
        ExpressaoCupom expressao = contexto.interpretarCodigo("FRETEGRATIS50");

        assertEquals(0.0, expressao.interpretar(30.00), 0.001);
    }
}
