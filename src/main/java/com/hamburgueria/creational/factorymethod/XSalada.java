package com.hamburgueria.creational.factorymethod;

public class XSalada extends Lanche {
    public XSalada() {
        this.nome = "X-Salada";
        this.precoBase = 17.50;
    }

    @Override
    public String getDescricao() {
        return "Pao, hamburguer de carne, queijo, alface e tomate";
    }
}
