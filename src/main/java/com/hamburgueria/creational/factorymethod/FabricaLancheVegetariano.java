package com.hamburgueria.creational.factorymethod;

public class FabricaLancheVegetariano extends FabricaLanche {
    @Override
    protected Lanche criarLanche() {
        return new LancheVegetariano();
    }
}
