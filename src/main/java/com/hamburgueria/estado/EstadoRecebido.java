package com.hamburgueria.estado;

import com.hamburgueria.estoque.EstadoCancelado;
import com.hamburgueria.pedido.PedidoComEstado;

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
