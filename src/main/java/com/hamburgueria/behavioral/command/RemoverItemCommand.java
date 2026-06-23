package com.hamburgueria.behavioral.command;

public class RemoverItemCommand implements PedidoCommand {

    private final Pedido pedido;
    private final String item;

    public RemoverItemCommand(Pedido pedido, String item) {
        this.pedido = pedido;
        this.item = item;
    }

    @Override
    public void executar() {
        pedido.removerItem(item);
    }

    @Override
    public void desfazer() {
        pedido.adicionarItem(item);
    }
}
