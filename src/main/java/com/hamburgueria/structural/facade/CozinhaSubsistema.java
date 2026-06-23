package com.hamburgueria.structural.facade;

/** Subsistema complexo: preparo do pedido na cozinha. */
public class CozinhaSubsistema {

    public void prepararPedido(String descricaoPedido) {
        System.out.printf("[Cozinha] Preparando: %s%n", descricaoPedido);
    }
}
