package com.hamburgueria.relatorio;

public class RelatorioFinanceiroVisitor implements RelatorioVisitor {

    private double totalAcumulado = 0.0;

    @Override
    public void visitar(LancheItem item) {
        totalAcumulado += item.getPreco();
        System.out.printf("[Financeiro] Lanche: %s -> R$ %.2f%n", item.getNome(), item.getPreco());
    }

    @Override
    public void visitar(BebidaItem item) {
        totalAcumulado += item.getPreco();
        System.out.printf("[Financeiro] Bebida: %s -> R$ %.2f%n", item.getNome(), item.getPreco());
    }

    @Override
    public void visitar(AcompanhamentoItem item) {
        totalAcumulado += item.getPreco();
        System.out.printf("[Financeiro] Acomp: %s -> R$ %.2f%n", item.getNome(), item.getPreco());
    }

    public double getTotalAcumulado() { return totalAcumulado; }
}
