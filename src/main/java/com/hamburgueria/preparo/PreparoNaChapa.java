package com.hamburgueria.preparo;

public class PreparoNaChapa implements MetodoPreparo {
    @Override
    public String preparar(String nomeIngredientePrincipal) {
        return nomeIngredientePrincipal + " grelhado na chapa";
    }
}
