package com.hamburgueria.structural.flyweight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.ingrediente.FabricaIngredientesFlyweight;
import com.hamburgueria.ingrediente.ItemPedido;
import com.hamburgueria.ingrediente.TipoIngrediente;

import static org.junit.jupiter.api.Assertions.*;

class FabricaIngredientesFlyweightTest {

    @Test
    @DisplayName("Fabrica deve retornar a mesma instancia para o mesmo ingrediente")
    void deveRetornarMesmaInstanciaParaMesmoIngrediente() {
        FabricaIngredientesFlyweight fabrica = new FabricaIngredientesFlyweight();

        TipoIngrediente queijo1 = fabrica.obterIngrediente("Queijo Cheddar", "fatia", 50);
        TipoIngrediente queijo2 = fabrica.obterIngrediente("Queijo Cheddar", "fatia", 50);

        assertSame(queijo1, queijo2, "Ambas as referencias devem apontar para o mesmo flyweight");
    }

    @Test
    @DisplayName("Fabrica deve criar apenas um flyweight mesmo apos multiplas solicitacoes do mesmo tipo")
    void deveCriarApenasUmFlyweightPorTipo() {
        FabricaIngredientesFlyweight fabrica = new FabricaIngredientesFlyweight();

        for (int i = 0; i < 1000; i++) {
            fabrica.obterIngrediente("Alface", "folha", 2);
        }

        assertEquals(1, fabrica.quantidadeDeFlyweightsCriados());
    }

    @Test
    @DisplayName("Ingredientes diferentes devem gerar flyweights diferentes")
    void ingredientesDiferentesDevemGerarFlyweightsDiferentes() {
        FabricaIngredientesFlyweight fabrica = new FabricaIngredientesFlyweight();

        fabrica.obterIngrediente("Bacon", "fatia", 40);
        fabrica.obterIngrediente("Tomate", "fatia", 5);
        fabrica.obterIngrediente("Cebola", "anel", 4);

        assertEquals(3, fabrica.quantidadeDeFlyweightsCriados());
    }

    @Test
    @DisplayName("Estado extrinseco (quantidade) deve refletir corretamente na descricao do pedido")
    void estadoExtrinsecoDeveSerAplicadoCorretamente() {
        FabricaIngredientesFlyweight fabrica = new FabricaIngredientesFlyweight();
        TipoIngrediente bacon = fabrica.obterIngrediente("Bacon", "fatia", 40);

        ItemPedido item = new ItemPedido(bacon, 3);

        assertEquals("3x Bacon (fatia) - 120 kcal", item.descrever());
    }

    @Test
    @DisplayName("Multiplos itens de pedido podem compartilhar o mesmo flyweight com quantidades diferentes")
    void multiplosItensPodemCompartilharFlyweightComQuantidadesDiferentes() {
        FabricaIngredientesFlyweight fabrica = new FabricaIngredientesFlyweight();
        TipoIngrediente queijo = fabrica.obterIngrediente("Queijo Cheddar", "fatia", 50);

        ItemPedido item1 = new ItemPedido(queijo, 1);
        ItemPedido item2 = new ItemPedido(queijo, 2);

        assertSame(item1.getTipoIngrediente(), item2.getTipoIngrediente());
        assertNotEquals(item1.descrever(), item2.descrever());
    }
}
