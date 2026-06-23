package com.hamburgueria.behavioral.state;

public class EstadoCancelado implements EstadoPedido {
    @Override
    public void avancar(PedidoComEstado pedido) {
        throw new IllegalStateException("Pedido cancelado nao pode avancar");
    }

    @Override
    public void cancelar(PedidoComEstado pedido) {
        throw new IllegalStateException("Pedido ja esta cancelado");
    }

    @Override
    public String nomeEstado() { return "CANCELADO"; }
}
