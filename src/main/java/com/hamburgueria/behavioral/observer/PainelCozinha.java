package com.hamburgueria.behavioral.observer;

public class PainelCozinha implements ObservadorPedido {
    private String ultimoStatus = "";

    @Override
    public void atualizar(int numeroPedido, String novoStatus) {
        ultimoStatus = novoStatus;
        System.out.printf("[PainelCozinha] Pedido #%d -> %s%n", numeroPedido, novoStatus);
    }

    public String getUltimoStatus() { return ultimoStatus; }
}
