package com.hamburgueria.structural.bridge;

public class HamburguerDeFrango extends ItemMenu {

    public HamburguerDeFrango(MetodoPreparo metodoPreparo) {
        super(metodoPreparo);
    }

    @Override
    public String montar() {
        return "Hamburguer de frango: " + metodoPreparo.preparar("file de peito de frango");
    }
}
