package com.hamburgueria.structural.proxy;

/**
 * Interface comum (Subject) implementada tanto pelo objeto real quanto
 * pelo proxy, permitindo que o cliente use ambos de forma transparente.
 */
public interface ServicoEstoque {
    int consultarQuantidade(String ingrediente);
    void atualizarQuantidade(String ingrediente, int novaQuantidade);
}
