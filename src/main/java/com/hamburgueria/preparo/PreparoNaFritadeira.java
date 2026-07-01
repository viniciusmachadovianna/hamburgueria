package com.hamburgueria.preparo;

public class PreparoNaFritadeira implements MetodoPreparo {
    @Override
    public String preparar(String nomeIngredientePrincipal) {
        return nomeIngredientePrincipal + " frito na fritadeira";
    }
}
