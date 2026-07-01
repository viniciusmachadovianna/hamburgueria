package com.hamburgueria.relatorio;

public class RelatorioNutricionalVisitor implements RelatorioVisitor {

    private int caloriasAcumuladas = 0;

    @Override
    public void visitar(LancheItem item) {
        caloriasAcumuladas += item.getCalorias();
        System.out.printf("[Nutricional] Lanche: %s -> %d kcal%n", item.getNome(), item.getCalorias());
    }

    @Override
    public void visitar(BebidaItem item) {
        caloriasAcumuladas += item.getCalorias();
        System.out.printf("[Nutricional] Bebida: %s -> %d kcal%n", item.getNome(), item.getCalorias());
    }

    @Override
    public void visitar(AcompanhamentoItem item) {
        caloriasAcumuladas += item.getCalorias();
        System.out.printf("[Nutricional] Acomp: %s -> %d kcal%n", item.getNome(), item.getCalorias());
    }

    public int getCaloriasAcumuladas() { return caloriasAcumuladas; }
}
