package com.hamburgueria.behavioral.templatemethod;

import java.util.ArrayList;
import java.util.List;

public abstract class PreparoLanche {

    protected final List<String> log = new ArrayList<>();

    public final void preparar() {
        separarIngredientes();
        cozinharProteina();
        montarLanche();
        embalar();
    }

    protected abstract void separarIngredientes();
    protected abstract void cozinharProteina();
    protected abstract void montarLanche();

    protected void embalar() {
        log.add("Embalando em papel kraft padrao");
    }

    public List<String> getLog() { return log; }
}
