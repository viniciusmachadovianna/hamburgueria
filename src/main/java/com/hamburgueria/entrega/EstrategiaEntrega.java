package com.hamburgueria.entrega;

public interface EstrategiaEntrega {
    double calcularCusto(double distanciaKm);
    int calcularTempoEstimado(double distanciaKm);
}
