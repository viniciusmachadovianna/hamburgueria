package com.hamburgueria.behavioral.state;

public interface EstadoPedido {
    void avancar(PedidoComEstado pedido);
    void cancelar(PedidoComEstado pedido);
    String nomeEstado();
}
