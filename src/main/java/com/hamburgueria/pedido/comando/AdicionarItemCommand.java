package com.hamburgueria.pedido.comando;

import com.hamburgueria.pedido.Pedido;

public class AdicionarItemCommand implements PedidoCommand {

    private final Pedido pedido;
    private final String item;

    public AdicionarItemCommand(Pedido pedido, String item) {
        this.pedido = pedido;
        this.item = item;
    }

    @Override
    public void executar() {
        pedido.adicionarItem(item);
    }

    @Override
    public void desfazer() {
        pedido.removerItem(item);
    }
}
