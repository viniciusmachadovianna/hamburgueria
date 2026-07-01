package com.hamburgueria.structural.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.cardapio.Combo;
import com.hamburgueria.cardapio.ItemCardapio;
import com.hamburgueria.cardapio.ItemSimples;

import static org.junit.jupiter.api.Assertions.*;

class ComboCompositeTest {

    @Test
    @DisplayName("Item simples deve calcular o proprio preco diretamente")
    void itemSimplesDeveCalcularPrecoDireto() {
        ItemCardapio item = new ItemSimples("X-Burguer", 15.90);

        assertEquals(15.90, item.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Combo deve somar os precos de todos os itens contidos")
    void comboDeveSomarPrecosDosItens() {
        Combo combo = new Combo("Combo Simples");
        combo.adicionar(new ItemSimples("X-Burguer", 15.90));
        combo.adicionar(new ItemSimples("Batata frita", 8.00));
        combo.adicionar(new ItemSimples("Refrigerante", 6.00));

        assertEquals(29.90, combo.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Combo deve aplicar desconto percentual sobre o total")
    void comboDeveAplicarDesconto() {
        Combo combo = new Combo("Combo com Desconto");
        combo.adicionar(new ItemSimples("X-Salada", 17.50));
        combo.adicionar(new ItemSimples("Batata media", 7.50));
        combo.definirDesconto(0.10);

        assertEquals(22.50, combo.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Combo deve poder conter outro combo (composicao recursiva)")
    void comboDeveSuportarComboAninhado() {
        Combo comboInterno = new Combo("Combo Lanche+Batata");
        comboInterno.adicionar(new ItemSimples("X-Burguer", 15.90));
        comboInterno.adicionar(new ItemSimples("Batata", 8.00));

        Combo comboExterno = new Combo("Combo Familia");
        comboExterno.adicionar(comboInterno);
        comboExterno.adicionar(new ItemSimples("Refrigerante 2L", 12.00));

        assertEquals(35.90, comboExterno.calcularPreco(), 0.001);
    }

    @Test
    @DisplayName("Cliente deve tratar item simples e combo de forma uniforme via ItemCardapio")
    void clienteDeveTratarFolhaECompostoUniformemente() {
        ItemCardapio folha = new ItemSimples("Suco", 7.00);
        Combo composto = new Combo("Combo Pequeno");
        composto.adicionar(new ItemSimples("Mini X-Burguer", 10.00));

        double totalGeral = folha.calcularPreco() + composto.calcularPreco();

        assertEquals(17.00, totalGeral, 0.001);
    }

    @Test
    @DisplayName("Definir desconto fora do intervalo valido deve lancar excecao")
    void definirDescontoInvalidoDeveLancarExcecao() {
        Combo combo = new Combo("Combo Invalido");

        assertThrows(IllegalArgumentException.class, () -> combo.definirDesconto(1.5));
    }
}
