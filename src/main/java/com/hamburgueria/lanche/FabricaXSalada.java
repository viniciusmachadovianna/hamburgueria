package com.hamburgueria.lanche;

public class FabricaXSalada extends FabricaLanche {
    @Override
    protected Lanche criarLanche() {
        return new XSalada();
    }
}
