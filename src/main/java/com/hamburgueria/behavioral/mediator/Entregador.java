package com.hamburgueria.behavioral.mediator;

public class Entregador extends Estacao {

    public Entregador(AtendimentoMediator mediator) {
        super("Entregador", mediator);
    }

    @Override
    public void receberNotificacao(String evento) {
        ultimoEvento = evento;
        if ("PEDIDO_PRONTO".equals(evento)) {
            System.out.println("[Entregador] Pedido pronto para retirada/entrega.");
        }
    }
}
