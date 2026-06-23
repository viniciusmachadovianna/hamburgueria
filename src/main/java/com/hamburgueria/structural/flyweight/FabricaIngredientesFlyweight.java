package com.hamburgueria.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Padrao FLYWEIGHT.
 *
 * Fabrica responsavel por garantir que cada TipoIngrediente seja criado
 * apenas uma vez e reutilizado (compartilhado) por todos os pedidos que o
 * referenciam, em vez de instanciar um novo objeto identico a cada lanche
 * montado. Em uma hamburgueria com milhares de pedidos por dia, evita
 * recriar o mesmo objeto "queijo cheddar" centenas de vezes.
 */
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
