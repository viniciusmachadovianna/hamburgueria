package com.hamburgueria.structural.composite;

/**
 * Folha (Leaf) do Composite: um item individual do cardapio, que nao
 * contem outros itens dentro de si (ex.: um lanche avulso, uma bebida).
 */
public class ItemSimples implements ItemCardapio {

    private final String nome;
    private final double preco;

    public ItemSimples(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }

    @Override
    public void imprimir(String prefixo) {
        System.out.printf("%s- %s (R$ %.2f)%n", prefixo, nome, preco);
    }
}
