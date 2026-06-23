package com.hamburgueria.structural.proxy;

public interface ServicoEstoque {
    int consultarQuantidade(String ingrediente);
    void atualizarQuantidade(String ingrediente, int novaQuantidade);
}
