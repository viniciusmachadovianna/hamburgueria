package com.hamburgueria.behavioral.interpreter;

public class DescontoPercentualExpressao implements ExpressaoCupom {

    private final double percentual;

    public DescontoPercentualExpressao(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double interpretar(double valorPedido) {
        return valorPedido * (1 - percentual);
    }
}
