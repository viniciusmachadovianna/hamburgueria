package com.hamburgueria.behavioral.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.cardapio.Cardapio;
import com.hamburgueria.cardapio.CardapioIterator;
import com.hamburgueria.cardapio.ItemMenuSimples;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardapioIteratorTest {

    private Cardapio cardapio;

    @BeforeEach
    void setUp() {
        cardapio = new Cardapio();
        cardapio.adicionarItem(new ItemMenuSimples("X-Burguer",    15.90, "Lanches"));
        cardapio.adicionarItem(new ItemMenuSimples("X-Salada",     17.50, "Lanches"));
        cardapio.adicionarItem(new ItemMenuSimples("Batata Frita",  8.00, "Acompanhamentos"));
        cardapio.adicionarItem(new ItemMenuSimples("Refrigerante",  6.00, "Bebidas"));
    }

    @Test
    @DisplayName("Iterator deve percorrer todos os itens do cardapio")
    void devePercorrerTodosOsItens() {
        CardapioIterator it = cardapio.criarIterator();
        List<String> nomes = new ArrayList<>();

        while (it.hasNext()) {
            nomes.add(it.next().getNome());
        }

        assertEquals(4, nomes.size());
        assertTrue(nomes.contains("X-Burguer"));
        assertTrue(nomes.contains("Refrigerante"));
    }

    @Test
    @DisplayName("Iterator filtrado por categoria deve retornar apenas itens da categoria")
    void deveIterarApenasItensDaCategoria() {
        CardapioIterator it = cardapio.criarIteratorPorCategoria("Lanches");
        int count = 0;

        while (it.hasNext()) {
            assertEquals("Lanches", it.next().getCategoria());
            count++;
        }

        assertEquals(2, count);
    }

    @Test
    @DisplayName("hasNext deve retornar false apos percorrer todos os itens")
    void hasNextDeveRetornarFalseAoFinal() {
        CardapioIterator it = cardapio.criarIterator();
        while (it.hasNext()) it.next();

        assertFalse(it.hasNext());
    }

    @Test
    @DisplayName("next sem hasNext deve lancar NoSuchElementException")
    void nextSemElementosDeveLancarExcecao() {
        CardapioIterator it = cardapio.criarIterator();
        while (it.hasNext()) it.next();

        assertThrows(java.util.NoSuchElementException.class, it::next);
    }
}
