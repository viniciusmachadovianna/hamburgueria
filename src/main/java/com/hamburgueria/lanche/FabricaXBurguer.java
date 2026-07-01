package com.hamburgueria.lanche;

public class FabricaXBurguer extends FabricaLanche {
    @Override
    protected Lanche criarLanche() {
        return new XBurguer();
    }
}
