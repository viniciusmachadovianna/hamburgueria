package com.hamburgueria.structural.bridge;

/**
 * Padrao BRIDGE.
 *
 * Desacopla a abstracao "tipo de lanche" da sua implementacao "metodo de
 * preparo", permitindo que ambas variem independentemente. Sem o Bridge,
 * teriamos uma explosao de subclasses (XBurguerNaChapa, XBurguerNaBrasa,
 * FrangoNaChapa, FrangoNaFritadeira, ...). Com o Bridge, cada tipo de
 * lanche simplesmente "contem" uma referencia a um MetodoPreparo, e novas
 * combinacoes sao feitas por composicao, nao por heranca.
 */
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
