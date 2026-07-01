package com.hamburgueria.preparo;

import com.hamburgueria.lanche.Lanche;

public class LancheVegetariano extends Lanche {
    public LancheVegetariano() {
        this.nome = "Lanche Vegetariano";
        this.precoBase = 18.90;
    }

    @Override
    public String getDescricao() {
        return "Pao integral, hamburguer de grao-de-bico, queijo vegano e rucula";
    }
}