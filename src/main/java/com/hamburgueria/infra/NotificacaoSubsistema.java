package com.hamburgueria.infra;

public class NotificacaoSubsistema {

    public void notificarCliente(String mensagem) {
        System.out.printf("[Notificacao] %s%n", mensagem);
    }
}
