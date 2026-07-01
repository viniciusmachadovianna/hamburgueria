package com.hamburgueria.pedido;

import java.util.ArrayList;
import java.util.List;

import com.hamburgueria.notificacao.ObservadorPedido;

public class PedidoObservavel {

    private final int numeroPedido;
    private String statusAtual;
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public PedidoObservavel(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.statusAtual  = "RECEBIDO";
    }

    public void inscrever(ObservadorPedido observador) {
        observadores.add(observador);
    }

    public void desinscrever(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    public void mudarStatus(String novoStatus) {
        this.statusAtual = novoStatus;
        notificarTodos();
    }

    private void notificarTodos() {
        for (ObservadorPedido obs : observadores) {
            obs.atualizar(numeroPedido, statusAtual);
        }
    }

    public String getStatusAtual() { return statusAtual; }
    public int getNumeroPedido()   { return numeroPedido; }
}
