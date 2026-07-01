package com.hamburgueria.pedido;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistoricoPedido {

    private final Deque<PedidoMemento> checkpoints = new ArrayDeque<>();

    public void salvar(PedidoMemento memento) {
        checkpoints.push(memento);
    }

    public PedidoMemento desfazer() {
        if (checkpoints.isEmpty()) return null;
        return checkpoints.pop();
    }

    public int quantidadeCheckpoints() {
        return checkpoints.size();
    }
}
