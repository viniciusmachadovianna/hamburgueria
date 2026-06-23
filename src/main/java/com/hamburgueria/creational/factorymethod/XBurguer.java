package com.hamburgueria.creational.factorymethod;

public class XBurguer extends Lanche {
    public XBurguer() {
        this.nome = "X-Burguer";
        this.precoBase = 15.90;
    }

    @Override
    public String getDescricao() {
        return "Pao, hamburguer de carne, queijo e molho especial";
    }
}
