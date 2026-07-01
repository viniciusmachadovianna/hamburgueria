package com.hamburgueria.lanche;

public abstract class FabricaLanche {

    protected abstract Lanche criarLanche();

    public Lanche pedir() {
        Lanche lanche = criarLanche();
        System.out.printf("Preparando %s: %s (R$ %.2f)%n",
                lanche.getNome(), lanche.getDescricao(), lanche.getPrecoBase());
        return lanche;
    }
}