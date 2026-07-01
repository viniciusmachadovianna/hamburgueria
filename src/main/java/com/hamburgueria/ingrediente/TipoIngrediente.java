package com.hamburgueria.ingrediente;

public class TipoIngrediente {

    private final String nome;
    private final String unidadeMedida;
    private final int calorias;

    public TipoIngrediente(String nome, String unidadeMedida, int calorias) {
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public int getCalorias() {
        return calorias;
    }

    /**
     * Operacao que recebe o estado EXTRINSECO (quantidade), fornecido pelo
     * contexto externo (o item do pedido), e nao armazenado no flyweight.
     */
    public String descreverNoPedido(int quantidade) {
        return String.format("%dx %s (%s) - %d kcal", quantidade, nome, unidadeMedida, calorias * quantidade);
    }
}
