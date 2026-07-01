package com.hamburgueria.lanche.adicionais;

public class ComQueijoExtra extends LancheDecorator {

    private static final double PRECO_ADICIONAL = 3.50;

    public ComQueijoExtra(LancheComponent lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + queijo extra";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + PRECO_ADICIONAL;
    }
}
