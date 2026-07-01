package com.hamburgueria.pedido.comando;

public interface PedidoCommand {
    void executar();
    void desfazer();
}
