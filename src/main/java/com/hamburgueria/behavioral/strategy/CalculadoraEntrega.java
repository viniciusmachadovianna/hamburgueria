package com.hamburgueria.behavioral.strategy;

public class CalculadoraEntrega {

    private EstrategiaEntrega estrategia;

    public CalculadoraEntrega(EstrategiaEntrega estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaEntrega estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularCusto(double distanciaKm) {
        return estrategia.calcularCusto(distanciaKm);
    }

    public int calcularTempo(double distanciaKm) {
        return estrategia.calcularTempoEstimado(distanciaKm);
    }
}
