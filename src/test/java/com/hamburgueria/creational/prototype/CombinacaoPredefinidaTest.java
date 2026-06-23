package com.hamburgueria.creational.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinacaoPredefinidaTest {

    @Test
    @DisplayName("Clone deve ser uma instancia diferente do original")
    void cloneDeveSerInstanciaDiferente() {
        CombinacaoPredefinida original = new CombinacaoPredefinida(
                "Combo Teste", "X-Burguer", "Batata", "Refrigerante", 30.0);

        CombinacaoPredefinida clone = original.clonar();

        assertNotSame(original, clone);
        assertEquals(original.getNomeCombo(), clone.getNomeCombo());
        assertEquals(original.getPreco(), clone.getPreco(), 0.001);
    }

    @Test
    @DisplayName("Alterar o clone nao deve afetar o prototipo original (deep copy de lista)")
    void alterarCloneNaoDeveAfetarOriginal() {
        CombinacaoPredefinida original = new CombinacaoPredefinida(
                "Combo Teste", "X-Burguer", "Batata", "Refrigerante", 30.0);
        original.adicionarObservacao("Sem cebola");

        CombinacaoPredefinida clone = original.clonar();
        clone.adicionarObservacao("Ponto da carne bem passado");
        clone.trocarBebida("Suco natural");

        assertEquals(1, original.getObservacoes().size());
        assertEquals(2, clone.getObservacoes().size());
        assertEquals("Refrigerante", original.getBebida());
        assertEquals("Suco natural", clone.getBebida());
    }

    @Test
    @DisplayName("RegistroCombos deve devolver sempre uma copia nova e independente")
    void registroDeveDevolverCopiaIndependente() {
        RegistroCombos registro = new RegistroCombos();

        CombinacaoPredefinida copia1 = registro.obterCopia("FAMILIA");
        CombinacaoPredefinida copia2 = registro.obterCopia("FAMILIA");
        copia1.adicionarObservacao("Aniversario");

        assertNotSame(copia1, copia2);
        assertEquals(1, copia1.getObservacoes().size());
        assertEquals(0, copia2.getObservacoes().size());
    }

    @Test
    @DisplayName("Buscar combo modelo inexistente deve lancar excecao")
    void buscarComboInexistenteDeveLancarExcecao() {
        RegistroCombos registro = new RegistroCombos();

        assertThrows(IllegalArgumentException.class, () -> registro.obterCopia("INEXISTENTE"));
    }
}
