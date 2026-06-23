package com.hamburgueria.creational.abstractfactory;

public class FabricaLinhaTradicional implements FabricaIngredientes {
    @Override
    public Pao criarPao() {
        return new PaoAustraliano();
    }

    @Override
    public MolhoEspecial criarMolho() {
        return new MolhoBarbecue();
    }
}
