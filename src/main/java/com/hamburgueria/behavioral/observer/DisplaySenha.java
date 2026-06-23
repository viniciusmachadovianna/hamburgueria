package com.hamburgueria.behavioral.observer;

public class DisplaySenha implements ObservadorPedido {
    private String ultimoStatus = "";

    @Override
    public void atualizar(int numeroPedido, String novoStatus) {
        ultimoStatus = novoStatus;
        System.out.printf("[DisplaySenha] Chamando senha do pedido #%d: %s%n", numeroPedido, novoStatus);
    }

    public String getUltimoStatus() { return ultimoStatus; }
}
