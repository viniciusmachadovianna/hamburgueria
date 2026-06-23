package com.hamburgueria.behavioral.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioVisitorTest {

    private List<ItemVisitavel> itensDoPedido;

    @BeforeEach
    void setUp() {
        itensDoPedido = List.of(
                new LancheItem("X-Burguer",   15.90, 520),
                new BebidaItem("Refrigerante",  6.00, 150),
                new AcompanhamentoItem("Batata Frita", 8.00, 340)
        );
    }

    @Test
    @DisplayName("RelatorioFinanceiro deve somar o preco de todos os tipos de item")
    void relatorioFinanceiroDeveSomarTodosOsPrecos() {
        RelatorioFinanceiroVisitor financeiro = new RelatorioFinanceiroVisitor();

        for (ItemVisitavel item : itensDoPedido) {
            item.aceitar(financeiro);
        }

        assertEquals(29.90, financeiro.getTotalAcumulado(), 0.001);
    }

    @Test
    @DisplayName("RelatorioNutricional deve somar as calorias de todos os tipos de item")
    void relatorioNutricionalDeveSomarCalorias() {
        RelatorioNutricionalVisitor nutricional = new RelatorioNutricionalVisitor();

        for (ItemVisitavel item : itensDoPedido) {
            item.aceitar(nutricional);
        }

        assertEquals(1010, nutricional.getCaloriasAcumuladas());
    }

    @Test
    @DisplayName("Dois visitors diferentes devem operar sobre os mesmos elementos sem modifica-los")
    void doisVisitorsDiferentesNaoDevemModificarOsItens() {
        RelatorioFinanceiroVisitor financeiro  = new RelatorioFinanceiroVisitor();
        RelatorioNutricionalVisitor nutricional = new RelatorioNutricionalVisitor();

        for (ItemVisitavel item : itensDoPedido) {
            item.aceitar(financeiro);
            item.aceitar(nutricional);
        }

        assertEquals(29.90, financeiro.getTotalAcumulado(), 0.001);
        assertEquals(1010,  nutricional.getCaloriasAcumuladas());
    }

    @Test
    @DisplayName("Novo visitor pode ser adicionado sem alterar as classes dos itens")
    void novoVisitorNaoAlteraClassesDosItens() {
        int[] contadorLanches = {0};
        RelatorioVisitor contadorVisitor = new RelatorioVisitor() {
            @Override public void visitar(LancheItem item)         { contadorLanches[0]++; }
            @Override public void visitar(BebidaItem item)         {  }
            @Override public void visitar(AcompanhamentoItem item) {  }
        };

        for (ItemVisitavel item : itensDoPedido) {
            item.aceitar(contadorVisitor);
        }

        assertEquals(1, contadorLanches[0]);
    }
}
