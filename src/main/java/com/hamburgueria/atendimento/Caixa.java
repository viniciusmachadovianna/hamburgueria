package com.hamburgueria.atendimento;

public class Caixa extends Estacao {

    public Caixa(AtendimentoMediator mediator) {
        super("Caixa", mediator);
    }

    public void registrarPedido() {
        System.out.println("[Caixa] Pedido registrado, notificando mediador.");
        mediator.notificar(this, "NOVO_PEDIDO");
    }

    @Override
    public void receberNotificacao(String evento) {
        ultimoEvento = evento;
        if ("PEDIDO_PRONTO".equals(evento)) {
            System.out.println("[Caixa] Pedido pronto, atualizando painel.");
        }
    }
}
