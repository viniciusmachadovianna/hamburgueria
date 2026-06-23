package com.hamburgueria.structural.bridge;

public class PreparoNaFritadeira implements MetodoPreparo {
    @Override
    public String preparar(String nomeIngredientePrincipal) {
        return nomeIngredientePrincipal + " frito na fritadeira";
    }
}
