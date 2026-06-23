package com.hamburgueria.creational.factorymethod;

public class FabricaXSalada extends FabricaLanche {
    @Override
    protected Lanche criarLanche() {
        return new XSalada();
    }
}
