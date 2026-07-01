package com.hamburgueria.ingrediente;

public class FabricaLinhaGourmet implements FabricaIngredientes {
    @Override
    public Pao criarPao() {
        return new PaoBrioche();
    }

    @Override
    public MolhoEspecial criarMolho() {
        return new MolhoTruffleMaionese();
    }
}
