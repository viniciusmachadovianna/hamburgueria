package com.hamburgueria.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyEstoque implements ServicoEstoque {

    private final EstoqueReal estoqueReal;
    private final Map<String, Integer> cacheConsultas = new HashMap<>();
    private final String perfilUsuario;

    public ProxyEstoque(String perfilUsuario) {
        this.estoqueReal = new EstoqueReal();
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public int consultarQuantidade(String ingrediente) {
        if (cacheConsultas.containsKey(ingrediente)) {
            System.out.println("[ProxyEstoque] Retornando do cache para " + ingrediente);
            return cacheConsultas.get(ingrediente);
        }
        int quantidade = estoqueReal.consultarQuantidade(ingrediente);
        cacheConsultas.put(ingrediente, quantidade);
        return quantidade;
    }

    @Override
    public void atualizarQuantidade(String ingrediente, int novaQuantidade) {
        if (!"GERENTE".equals(perfilUsuario)) {
            throw new SecurityException("Apenas o GERENTE pode atualizar o estoque.");
        }
        estoqueReal.atualizarQuantidade(ingrediente, novaQuantidade);
        cacheConsultas.put(ingrediente, novaQuantidade);
    }
}
