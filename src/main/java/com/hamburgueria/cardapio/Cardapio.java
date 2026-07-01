package com.hamburgueria.cardapio;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private final List<ItemMenuSimples> itens = new ArrayList<>();

    public void adicionarItem(ItemMenuSimples item) {
        itens.add(item);
    }

    public CardapioIterator criarIterator() {
        return new CardapioIteratorImpl(itens);
    }

    public CardapioIterator criarIteratorPorCategoria(String categoria) {
        List<ItemMenuSimples> filtrados = itens.stream()
                .filter(i -> i.getCategoria().equalsIgnoreCase(categoria))
                .toList();
        return new CardapioIteratorImpl(filtrados);
    }

    private static class CardapioIteratorImpl implements CardapioIterator {

        private final List<ItemMenuSimples> itens;
        private int posicaoAtual = 0;

        CardapioIteratorImpl(List<ItemMenuSimples> itens) {
            this.itens = itens;
        }

        @Override
        public boolean hasNext() {
            return posicaoAtual < itens.size();
        }

        @Override
        public ItemMenuSimples next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return itens.get(posicaoAtual++);
        }
    }
}
