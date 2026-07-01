package com.hamburgueria.structural.decorator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hamburgueria.lanche.adicionais.ComBacon;
import com.hamburgueria.lanche.adicionais.ComOvo;
import com.hamburgueria.lanche.adicionais.ComQueijoExtra;
import com.hamburgueria.lanche.adicionais.LancheComponent;
import com.hamburgueria.lanche.adicionais.LancheSimples;

import static org.junit.jupiter.api.Assertions.*;

class LancheDecoratorTest {

    @Test
    @DisplayName("Lanche simples deve ter preco e descricao originais sem decoracao")
    void lancheSimplesDeveTerPrecoOriginal() {
        LancheComponent lanche = new LancheSimples("X-Burguer", 15.90);

        assertEquals(15.90, lanche.getPreco(), 0.001);
        assertEquals("X-Burguer", lanche.getDescricao());
    }

    @Test
    @DisplayName("Decorar com um unico adicional deve somar preco e atualizar descricao")
    void deveDecorarComUmAdicional() {
        LancheComponent lanche = new ComBacon(new LancheSimples("X-Burguer", 15.90));

        assertEquals(20.40, lanche.getPreco(), 0.001);
        assertEquals("X-Burguer + bacon", lanche.getDescricao());
    }

    @Test
    @DisplayName("Decoradores devem poder ser empilhados em qualquer combinacao")
    void deveEmpilharMultiplosDecoradores() {
        LancheComponent lanche = new ComQueijoExtra(
                new ComOvo(
                        new ComBacon(
                                new LancheSimples("X-Salada", 17.50))));

        assertEquals(28.50, lanche.getPreco(), 0.001);
        assertEquals("X-Salada + bacon + ovo + queijo extra", lanche.getDescricao());
    }

    @Test
    @DisplayName("Ordem diferente de decoracao deve resultar no mesmo preco final (comutatividade da soma)")
    void ordemDeDecoracaoNaoDeveAlterarPrecoFinal() {
        LancheComponent lanche1 = new ComOvo(new ComBacon(new LancheSimples("X-Burguer", 15.90)));
        LancheComponent lanche2 = new ComBacon(new ComOvo(new LancheSimples("X-Burguer", 15.90)));

        assertEquals(lanche1.getPreco(), lanche2.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Cada decorador deve poder envolver outro decorador da mesma forma que envolve o componente base")
    void decoradorDeveEnvolverOutroDecorador() {
        LancheComponent base = new LancheSimples("Lanche Base", 10.0);
        LancheComponent comBacon = new ComBacon(base);

        LancheComponent comBaconEOvo = new ComOvo(comBacon);

        assertTrue(comBaconEOvo instanceof LancheComponent);
        assertEquals(16.50, comBaconEOvo.getPreco(), 0.001);
    }
}
