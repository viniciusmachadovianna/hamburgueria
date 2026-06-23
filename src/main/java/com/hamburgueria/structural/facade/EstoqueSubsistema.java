package com.hamburgueria.structural.facade;

public class EstoqueSubsistema {

    public boolean verificarDisponibilidade(String ingrediente, int quantidade) {
        System.out.printf("[Estoque] Verificando %d unidade(s) de %s...%n", quantidade, ingrediente);
        return true;
    }

    public void darBaixa(String ingrediente, int quantidade) {
        System.out.printf("[Estoque] Baixa de %d unidade(s) de %s realizada.%n", quantidade, ingrediente);
    }
}
