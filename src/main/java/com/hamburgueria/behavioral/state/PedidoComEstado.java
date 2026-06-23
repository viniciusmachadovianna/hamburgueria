package com.hamburgueria.behavioral.state;

public class PedidoComEstado {

    private EstadoPedido estadoAtual;

    public PedidoComEstado() {
        this.estadoAtual = new EstadoRecebido();
    }

    public void setEstado(EstadoPedido estado) {
        this.estadoAtual = estado;
    }

    public void avancar() {
        estadoAtual.avancar(this);
    }

    public void cancelar() {
        estadoAtual.cancelar(this);
    }

    public String getEstadoAtual() {
        return estadoAtual.nomeEstado();
    }
}
