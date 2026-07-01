package com.hamburgueria.estado;

import com.hamburgueria.pedido.PedidoComEstado;

public interface EstadoPedido {
    void avancar(PedidoComEstado pedido);
    void cancelar(PedidoComEstado pedido);
    String nomeEstado();
}
