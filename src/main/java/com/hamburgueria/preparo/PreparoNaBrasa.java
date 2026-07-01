package com.hamburgueria.preparo;

public class PreparoNaBrasa implements MetodoPreparo {
    @Override
    public String preparar(String nomeIngredientePrincipal) {
        return nomeIngredientePrincipal + " grelhado na brasa";
    }
}
