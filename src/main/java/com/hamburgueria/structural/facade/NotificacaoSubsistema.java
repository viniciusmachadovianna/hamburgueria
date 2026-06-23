package com.hamburgueria.structural.facade;

/** Subsistema complexo: notificacao do cliente sobre o status do pedido. */
public class NotificacaoSubsistema {

    public void notificarCliente(String mensagem) {
        System.out.printf("[Notificacao] %s%n", mensagem);
    }
}
