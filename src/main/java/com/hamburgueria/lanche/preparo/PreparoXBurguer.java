package com.hamburgueria.lanche.preparo;

import com.hamburgueria.lanche.PreparoLanche;

public class PreparoXBurguer extends PreparoLanche {

    @Override
    protected void separarIngredientes() {
        log.add("Separando: pao, carne 120g, queijo, molho");
    }

    @Override
    protected void cozinharProteina() {
        log.add("Grelhando carne na chapa por 3 minutos");
    }

    @Override
    protected void montarLanche() {
        log.add("Montando X-Burguer: pao + carne + queijo + molho");
    }
}
