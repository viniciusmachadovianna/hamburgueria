package com.hamburgueria.creational.abstractfactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaIngredientesTest {

    @Test
    @DisplayName("FabricaLinhaGourmet deve produzir Pao Brioche e Molho Truffle compativeis")
    void fabricaGourmetDeveProduzirFamiliaCompativel() {
        FabricaIngredientes fabrica = new FabricaLinhaGourmet();

        Pao pao = fabrica.criarPao();
        MolhoEspecial molho = fabrica.criarMolho();

        assertInstanceOf(PaoBrioche.class, pao);
        assertInstanceOf(MolhoTruffleMaionese.class, molho);
    }

    @Test
    @DisplayName("FabricaLinhaTradicional deve produzir Pao Australiano e Molho Barbecue compativeis")
    void fabricaTradicionalDeveProduzirFamiliaCompativel() {
        FabricaIngredientes fabrica = new FabricaLinhaTradicional();

        Pao pao = fabrica.criarPao();
        MolhoEspecial molho = fabrica.criarMolho();

        assertInstanceOf(PaoAustraliano.class, pao);
        assertInstanceOf(MolhoBarbecue.class, molho);
    }

    @Test
    @DisplayName("Nao deve ser possivel misturar produtos de familias diferentes via a mesma fabrica")
    void naoDeveMisturarFamiliasDeProdutos() {
        FabricaIngredientes gourmet = new FabricaLinhaGourmet();

        Pao pao = gourmet.criarPao();
        MolhoEspecial molho = gourmet.criarMolho();

        assertFalse(pao instanceof PaoAustraliano);
        assertFalse(molho instanceof MolhoBarbecue);
    }

    @Test
    @DisplayName("Cliente deve poder trocar a familia inteira trocando apenas a fabrica")
    void clienteDeveTrocarFamiliaTrocandoApenasAFabrica() {
        FabricaIngredientes[] fabricas = { new FabricaLinhaGourmet(), new FabricaLinhaTradicional() };

        for (FabricaIngredientes fabrica : fabricas) {
            assertNotNull(fabrica.criarPao().getDescricao());
            assertNotNull(fabrica.criarMolho().getDescricao());
        }
    }
}
