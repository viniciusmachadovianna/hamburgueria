package com.hamburgueria.estoque;

public interface ServicoEstoque {
    int consultarQuantidade(String ingrediente);
    void atualizarQuantidade(String ingrediente, int novaQuantidade);
}
