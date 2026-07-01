package com.hamburgueria.behavioral.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraEntregaTest {

    @Test
    @DisplayName("Retirada no balcao deve ter custo zero e tempo fixo de 10 min")
    void retiradaBalcaoDeveTerCustoZero() {
        CalculadoraEntrega calc = new CalculadoraEntrega(new RetiradaBalcao());

        assertEquals(0.0,  calc.calcularCusto(5.0),  0.001);
        assertEquals(10,   calc.calcularTempo(5.0));
    }

    @Test
    @DisplayName("Entrega padrao deve cobrar taxa base mais taxa por km")
    void entregaPadraoDeveCalcularCustoCorreto() {
        CalculadoraEntrega calc = new CalculadoraEntrega(new EntregaPadrao());

        assertEquals(9.50, calc.calcularCusto(3.0), 0.001);
    }

    @Test
    @DisplayName("Entrega expressa deve ser mais cara e mais rapida que a padrao")
    void entregaExpressaDevSerMaisCaraEMaisRapida() {
        CalculadoraEntrega padrao   = new CalculadoraEntrega(new EntregaPadrao());
        CalculadoraEntrega expressa = new CalculadoraEntrega(new EntregaExpressa());
        double distancia = 5.0;

        assertTrue(expressa.calcularCusto(distancia) > padrao.calcularCusto(distancia));
        assertTrue(expressa.calcularTempo(distancia) < padrao.calcularTempo(distancia));
    }

    @Test
    @DisplayName("Context deve poder trocar a estrategia em tempo de execucao")
    void devePoderTrocarEstrategiaEmTempoDeExecucao() {
        CalculadoraEntrega calc = new CalculadoraEntrega(new RetiradaBalcao());
        assertEquals(0.0, calc.calcularCusto(3.0), 0.001);

        calc.setEstrategia(new EntregaExpressa());

        assertTrue(calc.calcularCusto(3.0) > 0);
    }
}
