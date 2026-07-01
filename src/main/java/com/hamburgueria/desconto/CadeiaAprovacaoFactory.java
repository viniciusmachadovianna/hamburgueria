package com.hamburgueria.desconto;

import com.hamburgueria.desconto.aprovadores.AtendenteAprovador;
import com.hamburgueria.desconto.aprovadores.GerenteAprovador;
import com.hamburgueria.desconto.aprovadores.SupervisorAprovador;

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
