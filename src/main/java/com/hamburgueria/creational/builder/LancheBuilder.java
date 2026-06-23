package com.hamburgueria.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Padrao BUILDER.
 *
 * Separa a construcao de um objeto complexo (LancheCustomizado, com varias
 * opcoes independentes: pao, proteina, adicionais, restricoes alimentares)
 * da sua representacao final, permitindo construir o mesmo tipo de objeto
 * passo a passo de formas diferentes atraves de uma interface fluente
 * (method chaining).
 *
 * No dominio: o totem de autoatendimento ou o atendente monta o lanche do
 * cliente adicionando um item por vez, sem precisar de um construtor gigante
 * com dezenas de parametros posicionais.
 */
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
