package com.hamburgueria.atendimento;

public class CentralAtendimento implements AtendimentoMediator {

    private Cozinha cozinha;
    private Caixa caixa;
    private Entregador entregador;

    public void setCozinha(Cozinha cozinha)       { this.cozinha = cozinha; }
    public void setCaixa(Caixa caixa)             { this.caixa = caixa; }
    public void setEntregador(Entregador entregador) { this.entregador = entregador; }

    @Override
    public void notificar(Estacao remetente, String evento) {
        System.out.printf("[Central] Evento '%s' de '%s'%n", evento, remetente.getNome());

        switch (evento) {
            case "NOVO_PEDIDO"   -> cozinha.receberNotificacao(evento);
            case "PEDIDO_PRONTO" -> {
                caixa.receberNotificacao(evento);
                entregador.receberNotificacao(evento);
            }
            default -> System.out.println("[Central] Evento desconhecido: " + evento);
        }
    }
}
