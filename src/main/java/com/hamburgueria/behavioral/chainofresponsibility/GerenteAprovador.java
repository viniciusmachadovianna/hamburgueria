package com.hamburgueria.behavioral.chainofresponsibility;

public class GerenteAprovador extends AprovadorDesconto {

    @Override
    protected boolean podeAprovar(double percentual) {
        return percentual <= 1.0;
    }

    @Override
    protected String nomeCargo() {
        return "Gerente";
    }
}
