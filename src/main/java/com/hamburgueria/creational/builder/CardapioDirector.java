package com.hamburgueria.creational.builder;

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
