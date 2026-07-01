package com.hamburgueria.entrega;

public class EntregaPadrao implements EstrategiaEntrega {
    private static final double TAXA_BASE = 5.00;
    private static final double TAXA_KM   = 1.50;

    @Override
    public double calcularCusto(double distanciaKm) {
        return TAXA_BASE + (distanciaKm * TAXA_KM);
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return 30 + (int)(distanciaKm * 3);
    }
}
