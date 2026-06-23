package com.hamburgueria.behavioral.mediator;

public abstract class Estacao {

    protected AtendimentoMediator mediator;
    protected final String nome;
    protected String ultimoEvento = "";

    protected Estacao(String nome, AtendimentoMediator mediator) {
        this.nome = nome;
        this.mediator = mediator;
    }

    public String getNome()        { return nome; }
    public String getUltimoEvento() { return ultimoEvento; }

    public abstract void receberNotificacao(String evento);
}
