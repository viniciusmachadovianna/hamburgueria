package com.hamburgueria.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class LancheBuilder {

    String pao = "Pao tradicional";
    String proteina = "Hamburguer de carne 120g";
    List<String> adicionais = new ArrayList<>();
    boolean semGluten = false;
    boolean semLactose = false;

    public LancheBuilder comPao(String pao) {
        this.pao = pao;
        return this;
    }

    public LancheBuilder comProteina(String proteina) {
        this.proteina = proteina;
        return this;
    }

    public LancheBuilder adicionar(String ingrediente) {
        this.adicionais.add(ingrediente);
        return this;
    }

    public LancheBuilder semGluten() {
        this.semGluten = true;
        return this;
    }

    public LancheBuilder semLactose() {
        this.semLactose = true;
        return this;
    }

    public LancheCustomizado build() {
        if (proteina == null || proteina.isBlank()) {
            throw new IllegalStateException("Lanche precisa de uma proteina definida");
        }
        return new LancheCustomizado(this);
    }
}
