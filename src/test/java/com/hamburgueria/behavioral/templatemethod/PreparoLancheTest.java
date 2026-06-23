package com.hamburgueria.behavioral.templatemethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreparoLancheTest {

    @Test
    @DisplayName("Sequencia de preparo do X-Burguer deve seguir a ordem definida no template")
    void xBurguerDeveRespeitarOrdemDoTemplate() {
        PreparoLanche preparo = new PreparoXBurguer();
        preparo.preparar();
        List<String> log = preparo.getLog();

        assertEquals(4, log.size());
        assertTrue(log.get(0).contains("Separando"));
        assertTrue(log.get(1).contains("Grelhando"));
        assertTrue(log.get(2).contains("Montando"));
        assertTrue(log.get(3).contains("Embalando"));
    }

    @Test
    @DisplayName("Vegetariano deve sobrescrever o hook de embalagem")
    void vegetarianoDeveUsarEmbalagensEco() {
        PreparoLanche preparo = new PreparoLancheVegetariano();
        preparo.preparar();

        String embalagem = preparo.getLog().get(3);
        assertTrue(embalagem.contains("eco-friendly"));
    }

    @Test
    @DisplayName("X-Burguer deve usar embalagem padrao (hook nao sobrescrito)")
    void xBurguerDeveUsarEmbalagmPadrao() {
        PreparoLanche preparo = new PreparoXBurguer();
        preparo.preparar();

        assertTrue(preparo.getLog().get(3).contains("papel kraft padrao"));
    }

    @Test
    @DisplayName("Template method deve ser final — subclasses nao podem reordenar os passos")
    void templateMethodDeveSerFinal() throws NoSuchMethodException {
        var metodo = PreparoLanche.class.getDeclaredMethod("preparar");
        assertTrue(java.lang.reflect.Modifier.isFinal(metodo.getModifiers()));
    }
}
