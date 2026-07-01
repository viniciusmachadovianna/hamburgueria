package com.hamburgueria.preparo;

public abstract class ItemMenu {

    protected MetodoPreparo metodoPreparo;

    protected ItemMenu(MetodoPreparo metodoPreparo) {
        this.metodoPreparo = metodoPreparo;
    }

    public void trocarMetodoPreparo(MetodoPreparo novoMetodo) {
        this.metodoPreparo = novoMetodo;
    }

    public abstract String montar();
}
