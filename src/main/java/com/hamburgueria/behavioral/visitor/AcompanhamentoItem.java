package com.hamburgueria.behavioral.visitor;

public class AcompanhamentoItem implements ItemVisitavel {
    private final String nome;
    private final double preco;
    private final int calorias;

    public AcompanhamentoItem(String nome, double preco, int calorias) {
        this.nome = nome; this.preco = preco; this.calorias = calorias;
    }

    public String getNome()    { return nome; }
    public double getPreco()   { return preco; }
    public int getCalorias()   { return calorias; }

    @Override
    public void aceitar(RelatorioVisitor visitor) { visitor.visitar(this); }
}
