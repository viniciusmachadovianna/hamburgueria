package com.hamburgueria.lanche.adicionais;

public class ComBacon extends LancheDecorator {

    private static final double PRECO_ADICIONAL = 4.50;

    public ComBacon(LancheComponent lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + bacon";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + PRECO_ADICIONAL;
    }
}
