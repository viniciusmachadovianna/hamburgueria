package com.hamburgueria.structural.bridge;

public class PreparoNaChapa implements MetodoPreparo {
    @Override
    public String preparar(String nomeIngredientePrincipal) {
        return nomeIngredientePrincipal + " grelhado na chapa";
    }
}
