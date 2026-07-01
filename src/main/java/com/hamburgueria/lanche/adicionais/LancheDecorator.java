package com.hamburgueria.lanche.adicionais;

public abstract class LancheDecorator implements LancheComponent {

    protected final LancheComponent lancheDecorado;

    protected LancheDecorator(LancheComponent lancheDecorado) {
        this.lancheDecorado = lancheDecorado;
    }

    @Override
    public String getDescricao() {
        return lancheDecorado.getDescricao();
    }

    @Override
    public double getPreco() {
        return lancheDecorado.getPreco();
    }
}
