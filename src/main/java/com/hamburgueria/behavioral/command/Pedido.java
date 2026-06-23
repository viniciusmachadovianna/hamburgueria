package com.hamburgueria.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<String> itens = new ArrayList<>();

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public void removerItem(String item) {
        itens.remove(item);
    }

    public List<String> getItens() {
        return itens;
    }
}
