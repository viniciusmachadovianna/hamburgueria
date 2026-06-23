package com.hamburgueria.behavioral.command;

public interface PedidoCommand {
    void executar();
    void desfazer();
}
