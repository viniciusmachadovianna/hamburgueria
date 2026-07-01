package com.hamburgueria.structural.decorator;

public class ComOvo extends LancheDecorator {

    private static final double PRECO_ADICIONAL = 3.00;

    public ComOvo(LancheComponent lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + ovo";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + PRECO_ADICIONAL;
    }
}
