package com.hamburgueria.creational.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.lanche.FabricaLanche;
import com.hamburgueria.lanche.FabricaLancheVegetariano;
import com.hamburgueria.lanche.FabricaXBurguer;
import com.hamburgueria.lanche.FabricaXSalada;
import com.hamburgueria.lanche.Lanche;
import com.hamburgueria.lanche.XBurguer;
import com.hamburgueria.lanche.XSalada;
import com.hamburgueria.preparo.LancheVegetariano;

import static org.junit.jupiter.api.Assertions.*;

class FabricaLancheTest {

    @Test
    @DisplayName("FabricaXBurguer deve criar uma instancia de XBurguer")
    void fabricaXBurguerDeveCriarXBurguer() {
        FabricaLanche fabrica = new FabricaXBurguer();

        Lanche lanche = fabrica.pedir();

        assertInstanceOf(XBurguer.class, lanche);
        assertEquals("X-Burguer", lanche.getNome());
        assertEquals(15.90, lanche.getPrecoBase(), 0.001);
    }

    @Test
    @DisplayName("FabricaXSalada deve criar uma instancia de XSalada")
    void fabricaXSaladaDeveCriarXSalada() {
        FabricaLanche fabrica = new FabricaXSalada();

        Lanche lanche = fabrica.pedir();

        assertInstanceOf(XSalada.class, lanche);
        assertEquals("X-Salada", lanche.getNome());
    }

    @Test
    @DisplayName("FabricaLancheVegetariano deve criar lanche vegetariano com descricao correta")
    void fabricaVegetarianaDeveCriarLancheVegetariano() {
        FabricaLanche fabrica = new FabricaLancheVegetariano();

        Lanche lanche = fabrica.pedir();

        assertInstanceOf(LancheVegetariano.class, lanche);
        assertTrue(lanche.getDescricao().toLowerCase().contains("grao-de-bico"));
    }

    @Test
    @DisplayName("Cliente deve depender apenas da abstracao FabricaLanche/Lanche")
    void clienteDeveDependerApenasDaAbstracao() {
        FabricaLanche[] fabricas = { new FabricaXBurguer(), new FabricaXSalada(), new FabricaLancheVegetariano() };

        for (FabricaLanche fabrica : fabricas) {
            Lanche lanche = fabrica.pedir();
            assertNotNull(lanche.getNome());
            assertTrue(lanche.getPrecoBase() > 0);
        }
    }
}
