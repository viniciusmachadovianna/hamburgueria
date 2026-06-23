package com.hamburgueria.behavioral.observer;

public class AppNotificacao implements ObservadorPedido {
    private String ultimoStatus = "";

    @Override
    public void atualizar(int numeroPedido, String novoStatus) {
        ultimoStatus = novoStatus;
        System.out.printf("[App] Push notification: pedido #%d esta %s%n", numeroPedido, novoStatus);
    }

    public String getUltimoStatus() { return ultimoStatus; }
}
