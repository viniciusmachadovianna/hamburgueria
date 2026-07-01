package com.hamburgueria.relatorio;

public class LancheItem implements ItemVisitavel {
    private final String nome;
    private final double preco;
    private final int calorias;

    public LancheItem(String nome, double preco, int calorias) {
        this.nome = nome; this.preco = preco; this.calorias = calorias;
    }

    public String getNome()    { return nome; }
    public double getPreco()   { return preco; }
    public int getCalorias()   { return calorias; }

    @Override
    public void aceitar(RelatorioVisitor visitor) { visitor.visitar(this); }
}
