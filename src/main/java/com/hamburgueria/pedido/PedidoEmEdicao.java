package com.hamburgueria.pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoEmEdicao {

    private final List<String> itens = new ArrayList<>();
    private double total = 0.0;

    public void adicionarItem(String item, double preco) {
        itens.add(item);
        total += preco;
    }

    public PedidoMemento salvarEstado() {
        return new PedidoMemento(itens, total);
    }

    public void restaurarEstado(PedidoMemento memento) {
        itens.clear();
        itens.addAll(memento.getItensSalvos());
        total = memento.getTotalSalvo();
    }

    public List<String> getItens() { return List.copyOf(itens); }
    public double getTotal()       { return total; }
}
