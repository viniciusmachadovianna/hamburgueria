package com.hamburgueria.behavioral.chainofresponsibility;

public class CadeiaAprovacaoFactory {

    public static AprovadorDesconto criarCadeiaPadrao() {
        AprovadorDesconto atendente = new AtendenteAprovador();
        AprovadorDesconto supervisor = new SupervisorAprovador();
        AprovadorDesconto gerente = new GerenteAprovador();

        atendente.setProximo(supervisor);
        supervisor.setProximo(gerente);

        return atendente;
    }
}
