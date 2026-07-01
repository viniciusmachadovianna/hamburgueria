package com.hamburgueria.lanche.preparo;

import com.hamburgueria.lanche.PreparoLanche;

public class PreparoLancheVegetariano extends PreparoLanche {

    @Override
    protected void separarIngredientes() {
        log.add("Separando: pao integral, hamburguer de grao-de-bico, rucula, tomate");
    }

    @Override
    protected void cozinharProteina() {
        log.add("Assando hamburguer vegano por 4 minutos");
    }

    @Override
    protected void montarLanche() {
        log.add("Montando Lanche Vegetariano com rucula e tomate");
    }

    @Override
    protected void embalar() {
        log.add("Embalando em caixa eco-friendly compostavel");
    }
}
