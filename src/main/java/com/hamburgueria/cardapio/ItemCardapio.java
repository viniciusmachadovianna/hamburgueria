package com.hamburgueria.cardapio;

public interface ItemCardapio {
    String getNome();
    double calcularPreco();
    void imprimir(String prefixo);
}
