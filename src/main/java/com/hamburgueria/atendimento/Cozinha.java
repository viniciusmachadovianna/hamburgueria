package com.hamburgueria.atendimento;

public class Cozinha extends Estacao {

    public Cozinha(AtendimentoMediator mediator) {
        super("Cozinha", mediator);
    }

    public void pedidoPronto() {
        System.out.println("[Cozinha] Pedido pronto, notificando mediador.");
        mediator.notificar(this, "PEDIDO_PRONTO");
    }

    @Override
    public void receberNotificacao(String evento) {
        ultimoEvento = evento;
        if ("NOVO_PEDIDO".equals(evento)) {
            System.out.println("[Cozinha] Novo pedido recebido, iniciando preparo.");
        }
    }
}
