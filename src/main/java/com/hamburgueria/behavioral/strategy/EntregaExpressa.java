package com.hamburgueria.behavioral.strategy;

public class EntregaExpressa implements EstrategiaEntrega {
    private static final double TAXA_BASE = 12.00;
    private static final double TAXA_KM   = 2.50;

    @Override
    public double calcularCusto(double distanciaKm) {
        return TAXA_BASE + (distanciaKm * TAXA_KM);
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return 15 + (int)(distanciaKm * 1.5);
    }
}
