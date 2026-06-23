package com.hamburgueria.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {

    private final String nome;
    private final List<ItemCardapio> itens = new ArrayList<>();
    private double percentualDesconto = 0.0;

    public Combo(String nome) {
        this.nome = nome;
    }

    public void adicionar(ItemCardapio item) {
        itens.add(item);
    }

    public void remover(ItemCardapio item) {
        itens.remove(item);
    }

    public void definirDesconto(double percentual) {
        if (percentual < 0 || percentual > 1) {
            throw new IllegalArgumentException("Percentual de desconto deve estar entre 0 e 1");
        }
        this.percentualDesconto = percentual;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double calcularPreco() {
        double total = itens.stream().mapToDouble(ItemCardapio::calcularPreco).sum();
        return total * (1 - percentualDesconto);
    }

    @Override
    public void imprimir(String prefixo) {
        System.out.printf("%s+ %s (total: R$ %.2f)%n", prefixo, nome, calcularPreco());
        for (ItemCardapio item : itens) {
            item.imprimir(prefixo + "  ");
        }
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }
}
