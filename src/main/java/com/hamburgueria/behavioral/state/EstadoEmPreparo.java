package com.hamburgueria.behavioral.state;

public class EstadoEmPreparo implements EstadoPedido {
    @Override
    public void avancar(PedidoComEstado pedido) {
        pedido.setEstado(new EstadoPronto());
    }

    @Override
    public void cancelar(PedidoComEstado pedido) {
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String nomeEstado() { return "EM_PREPARO"; }
}
