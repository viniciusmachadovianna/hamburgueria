package com.hamburgueria.creational.abstractfactory;

/** Produto concreto - familia "Linha Tradicional". */
public class PaoAustraliano implements Pao {
    @Override
    public String getDescricao() {
        return "Pao australiano escuro e macio";
    }
}
