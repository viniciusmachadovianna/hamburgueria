package com.hamburgueria.creational.singleton;

public final class CaixaRegistradora {

    private static final CaixaRegistradora INSTANCIA = new CaixaRegistradora();

    private double saldoEmCaixa;
    private int totalVendasRegistradas;

    private CaixaRegistradora() {
        this.saldoEmCaixa = 0.0;
        this.totalVendasRegistradas = 0;
    }

    public static CaixaRegistradora getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrarVenda(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor da venda nao pode ser negativo");
        }
        this.saldoEmCaixa += valor;
        this.totalVendasRegistradas++;
    }

    public synchronized void registrarSangria(double valor) {
        if (valor < 0 || valor > saldoEmCaixa) {
            throw new IllegalArgumentException("Valor de sangria invalido");
        }
        this.saldoEmCaixa -= valor;
    }

    public double getSaldoEmCaixa() {
        return saldoEmCaixa;
    }

    public int getTotalVendasRegistradas() {
        return totalVendasRegistradas;
    }

}