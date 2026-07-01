package com.hamburgueria.cardapio;

public class ItemMenuSimples {
    private final String nome;
    private final double preco;
    private final String categoria;

    public ItemMenuSimples(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome()      { return nome; }
    public double getPreco()     { return preco; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return String.format("%s (R$ %.2f) [%s]", nome, preco, categoria);
    }
}
