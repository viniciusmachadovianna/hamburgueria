package com.hamburgueria.creational.abstractfactory;

/** Produto concreto - familia "Linha Gourmet". */
public class PaoBrioche implements Pao {
    @Override
    public String getDescricao() {
        return "Pao brioche amanteigado";
    }
}
