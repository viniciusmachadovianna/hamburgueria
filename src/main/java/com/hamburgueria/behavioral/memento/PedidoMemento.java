package com.hamburgueria.behavioral.memento;

import java.util.List;

public class PedidoMemento {

    private final List<String> itensSalvos;
    private final double totalSalvo;

    PedidoMemento(List<String> itens, double total) {
        this.itensSalvos = List.copyOf(itens);
        this.totalSalvo  = total;
    }

    List<String> getItensSalvos() { return itensSalvos; }
    double getTotalSalvo()        { return totalSalvo; }
}
