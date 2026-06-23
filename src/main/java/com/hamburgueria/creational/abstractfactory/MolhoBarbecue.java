package com.hamburgueria.creational.abstractfactory;

/** Produto concreto - familia "Linha Tradicional". */
public class MolhoBarbecue implements MolhoEspecial {
    @Override
    public String getDescricao() {
        return "Molho barbecue defumado";
    }
}
