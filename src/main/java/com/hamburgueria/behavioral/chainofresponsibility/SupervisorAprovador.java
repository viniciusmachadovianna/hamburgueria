package com.hamburgueria.behavioral.chainofresponsibility;

public class SupervisorAprovador extends AprovadorDesconto {
    private static final double LIMITE = 0.25;

    @Override
    protected boolean podeAprovar(double percentual) {
        return percentual <= LIMITE;
    }

    @Override
    protected String nomeCargo() {
        return "Supervisor";
    }
}
