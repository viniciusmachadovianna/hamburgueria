package com.hamburgueria.creational.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.lanche.CardapioDirector;
import com.hamburgueria.lanche.LancheBuilder;
import com.hamburgueria.lanche.LancheCustomizado;

import static org.junit.jupiter.api.Assertions.*;

class LancheBuilderTest {

    @Test
    @DisplayName("Builder deve montar lanche customizado passo a passo")
    void deveMontarLancheCustomizadoPassoAPasso() {
        LancheCustomizado lanche = new LancheBuilder()
                .comPao("Pao brioche")
                .comProteina("Hamburguer de carne 150g")
                .adicionar("Queijo cheddar")
                .adicionar("Bacon")
                .build();

        assertEquals("Pao brioche", lanche.getPao());
        assertEquals("Hamburguer de carne 150g", lanche.getProteina());
        assertEquals(2, lanche.getAdicionais().size());
        assertTrue(lanche.getAdicionais().contains("Bacon"));
    }

    @Test
    @DisplayName("Builder deve usar valores padrao quando metodos opcionais nao sao chamados")
    void deveUsarValoresPadraoQuandoNaoCustomizado() {
        LancheCustomizado lanche = new LancheBuilder().build();

        assertEquals("Pao tradicional", lanche.getPao());
        assertEquals("Hamburguer de carne 120g", lanche.getProteina());
        assertTrue(lanche.getAdicionais().isEmpty());
        assertFalse(lanche.isSemGluten());
    }

    @Test
    @DisplayName("Flags de restricao alimentar devem ser aplicadas corretamente")
    void deveAplicarRestricoesAlimentares() {
        LancheCustomizado lanche = new LancheBuilder()
                .semGluten()
                .semLactose()
                .build();

        assertTrue(lanche.isSemGluten());
        assertTrue(lanche.isSemLactose());
    }

    @Test
    @DisplayName("Build deve lancar excecao se proteina ficar vazia explicitamente")
    void deveLancarExcecaoSeProteinaForVazia() {
        LancheBuilder builder = new LancheBuilder().comProteina("   ");

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    @DisplayName("Director deve montar receita Duplo Bacon conhecida do cardapio")
    void directorDeveMontarReceitaDuploBacon() {
        CardapioDirector director = new CardapioDirector();

        LancheCustomizado duploBacon = director.montarDuploBacon(new LancheBuilder());

        assertEquals("Pao brioche", duploBacon.getPao());
        assertTrue(duploBacon.getAdicionais().contains("Bacon crocante"));
        assertTrue(duploBacon.getAdicionais().contains("Cebola caramelizada"));
    }

    @Test
    @DisplayName("Director deve montar receita Fit sem lactose")
    void directorDeveMontarReceitaFit() {
        CardapioDirector director = new CardapioDirector();

        LancheCustomizado fit = director.montarLancheFit(new LancheBuilder());

        assertTrue(fit.isSemLactose());
        assertEquals("Peito de frango grelhado", fit.getProteina());
    }
}
