package com.hamburgueria.structural.adapter;

/**
 * Interface alvo (Target) que o sistema da hamburgueria espera usar
 * internamente para processar qualquer forma de pagamento.
 */
public interface ProcessadorPagamento {
    boolean processarPagamento(double valor);
}
