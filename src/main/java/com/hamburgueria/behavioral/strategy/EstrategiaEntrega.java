package com.hamburgueria.behavioral.strategy;

public interface EstrategiaEntrega {
    double calcularCusto(double distanciaKm);
    int calcularTempoEstimado(double distanciaKm);
}
