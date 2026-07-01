package com.hamburgueria.lanche.adicionais;

public class LancheSimples implements LancheComponent {

    private final String nome;
    private final double precoBase;

    public LancheSimples(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    @Override
    public String getDescricao() {
        return nome;
    }

    @Override
    public double getPreco() {
        return precoBase;
    }
}
