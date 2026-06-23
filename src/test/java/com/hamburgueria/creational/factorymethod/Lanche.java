package com.hamburgueria.creational.factorymethod;

public abstract class Lanche {

    protected String nome;
    protected double precoBase;

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract String getDescricao();
}
