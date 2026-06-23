package com.hamburgueria.structural.bridge;

public class HamburguerDeCarne extends ItemMenu {

    public HamburguerDeCarne(MetodoPreparo metodoPreparo) {
        super(metodoPreparo);
    }

    @Override
    public String montar() {
        return "Hamburguer de carne: " + metodoPreparo.preparar("disco de carne 120g");
    }
}
