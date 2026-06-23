package com.hamburgueria.behavioral.state;

public class EstadoPronto implements EstadoPedido {
    @Override
    public void avancar(PedidoComEstado pedido) {
        pedido.setEstado(new EstadoEntregue());
    }

    @Override
    public void cancelar(PedidoComEstado pedido) {
        throw new IllegalStateException("Pedido ja pronto nao pode ser cancelado");
    }

    @Override
    public String nomeEstado() { return "PRONTO"; }
}
