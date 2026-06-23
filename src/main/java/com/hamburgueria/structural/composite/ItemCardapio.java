package com.hamburgueria.structural.composite;

public interface ItemCardapio {
    String getNome();
    double calcularPreco();
    void imprimir(String prefixo);
}
