package com.hamburgueria.lanche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LancheCustomizado {

    private final String pao;
    private final String proteina;
    private final List<String> adicionais;
    private final boolean semGluten;
    private final boolean semLactose;

    LancheCustomizado(LancheBuilder builder) {
        this.pao = builder.pao;
        this.proteina = builder.proteina;
        this.adicionais = Collections.unmodifiableList(new ArrayList<>(builder.adicionais));
        this.semGluten = builder.semGluten;
        this.semLactose = builder.semLactose;
    }

    public String getPao() {
        return pao;
    }

    public String getProteina() {
        return proteina;
    }

    public List<String> getAdicionais() {
        return adicionais;
    }

    public boolean isSemGluten() {
        return semGluten;
    }

    public boolean isSemLactose() {
        return semLactose;
    }

    @Override
    public String toString() {
        return String.format("LancheCustomizado{pao='%s', proteina='%s', adicionais=%s, semGluten=%s, semLactose=%s}",
                pao, proteina, adicionais, semGluten, semLactose);
    }
}
