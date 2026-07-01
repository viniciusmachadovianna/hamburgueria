package com.hamburgueria.ingrediente;

import java.util.HashMap;
import java.util.Map;

public class FabricaIngredientesFlyweight {

    private final Map<String, TipoIngrediente> cache = new HashMap<>();

    public TipoIngrediente obterIngrediente(String nome, String unidadeMedida, int calorias) {
        String chave = nome.toLowerCase();
        return cache.computeIfAbsent(chave, k -> new TipoIngrediente(nome, unidadeMedida, calorias));
    }

    public int quantidadeDeFlyweightsCriados() {
        return cache.size();
    }
}
