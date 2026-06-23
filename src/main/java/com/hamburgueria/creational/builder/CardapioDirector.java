package com.hamburgueria.creational.builder;

/**
 * Director (opcional no padrao Builder, mas presente na formulacao original
 * do GoF). Encapsula sequencias conhecidas de chamadas ao builder para
 * montar lanches "de cardapio" sem que o cliente precise conhecer a receita.
 */
public class CardapioDirector {

    public LancheCustomizado montarDuploBacon(LancheBuilder builder) {
        return builder
                .comPao("Pao brioche")
                .comProteina("Dois hamburgueres de carne 120g")
                .adicionar("Bacon crocante")
                .adicionar("Queijo cheddar")
                .adicionar("Cebola caramelizada")
                .build();
    }

    public LancheCustomizado montarLancheFit(LancheBuilder builder) {
        return builder
                .comPao("Pao integral light")
                .comProteina("Peito de frango grelhado")
                .adicionar("Alface")
                .adicionar("Tomate")
                .semLactose()
                .build();
    }
}
