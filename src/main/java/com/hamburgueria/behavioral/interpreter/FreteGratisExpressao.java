package com.hamburgueria.behavioral.interpreter;

public class FreteGratisExpressao implements ExpressaoCupom {

    private final double valorFrete;

    public FreteGratisExpressao(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    @Override
    public double interpretar(double valorPedido) {
        return Math.max(0, valorPedido - valorFrete);
    }
}
