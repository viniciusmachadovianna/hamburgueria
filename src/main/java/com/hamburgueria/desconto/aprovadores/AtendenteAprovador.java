package com.hamburgueria.desconto.aprovadores;

import com.hamburgueria.desconto.AprovadorDesconto;

public class AtendenteAprovador extends AprovadorDesconto {
    private static final double LIMITE = 0.10;

    @Override
    protected boolean podeAprovar(double percentual) {
        return percentual <= LIMITE;
    }

    @Override
    protected String nomeCargo() {
        return "Atendente";
    }
}
