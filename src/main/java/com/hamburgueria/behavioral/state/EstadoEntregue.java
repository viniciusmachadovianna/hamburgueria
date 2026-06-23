package com.hamburgueria.behavioral.state;

public class EstadoEntregue implements EstadoPedido {
    @Override
    public void avancar(PedidoComEstado pedido) {
        throw new IllegalStateException("Pedido ja entregue nao pode avancar");
    }

    @Override
    public void cancelar(PedidoComEstado pedido) {
        throw new IllegalStateException("Pedido ja entregue nao pode ser cancelado");
    }

    @Override
    public String nomeEstado() { return "ENTREGUE"; }
}
