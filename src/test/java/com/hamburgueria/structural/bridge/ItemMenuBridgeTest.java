package com.hamburgueria.structural.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemMenuBridgeTest {

    @Test
    @DisplayName("Hamburguer de carne deve poder ser preparado na chapa")
    void hamburguerDeCarneNaChapa() {
        ItemMenu item = new HamburguerDeCarne(new PreparoNaChapa());

        String resultado = item.montar();

        assertTrue(resultado.contains("Hamburguer de carne"));
        assertTrue(resultado.contains("grelhado na chapa"));
    }

    @Test
    @DisplayName("Mesmo tipo de lanche deve poder trocar o metodo de preparo em tempo de execucao")
    void deveTrocarMetodoPreparoEmTempoDeExecucao() {
        ItemMenu item = new HamburguerDeFrango(new PreparoNaFritadeira());
        assertTrue(item.montar().contains("frito na fritadeira"));

        item.trocarMetodoPreparo(new PreparoNaBrasa());

        assertTrue(item.montar().contains("grelhado na brasa"));
    }

    @Test
    @DisplayName("Diferentes abstracoes devem poder usar a mesma implementacao de preparo")
    void diferentesAbstracoesDevemReutilizarMesmaImplementacao() {
        MetodoPreparo chapa = new PreparoNaChapa();

        ItemMenu carne = new HamburguerDeCarne(chapa);
        ItemMenu frango = new HamburguerDeFrango(chapa);

        assertTrue(carne.montar().contains("na chapa"));
        assertTrue(frango.montar().contains("na chapa"));
    }

    @Test
    @DisplayName("Combinacoes diferentes de abstracao e implementacao geram resultados distintos")
    void combinacoesDiferentesGeramResultadosDistintos() {
        ItemMenu carneChapa = new HamburguerDeCarne(new PreparoNaChapa());
        ItemMenu frangoBrasa = new HamburguerDeFrango(new PreparoNaBrasa());

        assertNotEquals(carneChapa.montar(), frangoBrasa.montar());
    }
}
