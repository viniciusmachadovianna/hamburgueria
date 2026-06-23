package com.hamburgueria.creational.factorymethod;

public class FabricaXBurguer extends FabricaLanche {
    @Override
    protected Lanche criarLanche() {
        return new XBurguer();
    }
}
