package com.hamburgueria.behavioral.strategy;

public class RetiradaBalcao implements EstrategiaEntrega {
    @Override
    public double calcularCusto(double distanciaKm) { return 0.0; }

    @Override
    public int calcularTempoEstimado(double distanciaKm) { return 10; }
}
