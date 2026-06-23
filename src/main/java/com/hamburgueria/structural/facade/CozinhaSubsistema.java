package com.hamburgueria.structural.facade;

public class CozinhaSubsistema {

    public void prepararPedido(String descricaoPedido) {
        System.out.printf("[Cozinha] Preparando: %s%n", descricaoPedido);
    }
}
