package com.hamburgueria.behavioral.state;

public class EstadoRecebido implements EstadoPedido {
    @Override
    public void avancar(PedidoComEstado pedido) {
        pedido.setEstado(new EstadoEmPreparo());
    }

    @Override
    public void cancelar(PedidoComEstado pedido) {
        pedido.setEstado(new EstadoCancelado());
    }

    @Override
    public String nomeEstado() { return "RECEBIDO"; }
}
