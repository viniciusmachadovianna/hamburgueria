package com.hamburgueria.atendimento;

import java.util.ArrayDeque;
import java.util.Deque;

import com.hamburgueria.pedido.comando.PedidoCommand;

public class Garcom {

    private final Deque<PedidoCommand> historico = new ArrayDeque<>();

    public void executarComando(PedidoCommand comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimo() {
        if (!historico.isEmpty()) {
            PedidoCommand ultimo = historico.pop();
            ultimo.desfazer();
        }
    }

    public int quantidadeComandosNoHistorico() {
        return historico.size();
    }
}
