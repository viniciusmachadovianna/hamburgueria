package com.hamburgueria.creational.abstractfactory;

/** Produto concreto - familia "Linha Gourmet". */
public class MolhoTruffleMaionese implements MolhoEspecial {
    @Override
    public String getDescricao() {
        return "Maionese trufada artesanal";
    }
}
