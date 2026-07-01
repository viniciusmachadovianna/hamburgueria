package com.hamburgueria.desconto.aprovadores;

import com.hamburgueria.desconto.AprovadorDesconto;

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
