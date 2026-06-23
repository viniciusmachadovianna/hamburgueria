package com.hamburgueria.structural.composite;

/**
 * Padrao COMPOSITE.
 *
 * Permite tratar objetos individuais (um lanche) e composicoes de objetos
 * (um combo contendo varios itens, inclusive outros combos) de forma
 * uniforme atraves da mesma interface. O calculo de preco total de um
 * pedido funciona da mesma forma seja ele um unico item ou uma arvore
 * complexa de combos aninhados.
 */
public interface ItemCardapio {
    String getNome();
    double calcularPreco();
    void imprimir(String prefixo);
}
