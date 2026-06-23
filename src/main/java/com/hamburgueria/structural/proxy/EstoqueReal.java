package com.hamburgueria.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class EstoqueReal implements ServicoEstoque {

    private final Map<String, Integer> quantidades = new HashMap<>();

    public EstoqueReal() {
        quantidades.put("Pao", 200);
        quantidades.put("Carne", 150);
        quantidades.put("Queijo", 300);
    }

    @Override
    public int consultarQuantidade(String ingrediente) {
        System.out.println("[EstoqueReal] Consultando banco de dados de estoque...");
        return quantidades.getOrDefault(ingrediente, 0);
    }

    @Override
    public void atualizarQuantidade(String ingrediente, int novaQuantidade) {
        System.out.println("[EstoqueReal] Persistindo nova quantidade no banco de dados...");
        quantidades.put(ingrediente, novaQuantidade);
    }
}
