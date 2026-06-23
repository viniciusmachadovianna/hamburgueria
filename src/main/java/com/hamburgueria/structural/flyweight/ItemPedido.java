package com.hamburgueria.structural.flyweight;

/**
 * Contexto que combina o estado extrinseco (quantidade, especifico de cada
 * pedido) com a referencia ao flyweight compartilhado (TipoIngrediente).
 */
public class ItemPedido {

    private final TipoIngrediente tipoIngrediente;
    private final int quantidade;

    public ItemPedido(TipoIngrediente tipoIngrediente, int quantidade) {
        this.tipoIngrediente = tipoIngrediente;
        this.quantidade = quantidade;
    }

    public String descrever() {
        return tipoIngrediente.descreverNoPedido(quantidade);
    }

    public TipoIngrediente getTipoIngrediente() {
        return tipoIngrediente;
    }
}
