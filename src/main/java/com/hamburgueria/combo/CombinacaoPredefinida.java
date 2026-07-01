package com.hamburgueria.combo;

import java.util.ArrayList;
import java.util.List;

public class CombinacaoPredefinida implements CombinacaoPrototype {

    private String nomeCombo;
    private String lanche;
    private String acompanhamento;
    private String bebida;
    private List<String> observacoes;
    private double preco;

    public CombinacaoPredefinida(String nomeCombo, String lanche, String acompanhamento,
                                  String bebida, double preco) {
        this.nomeCombo = nomeCombo;
        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.preco = preco;
        this.observacoes = new ArrayList<>();
    }

    @Override
    public CombinacaoPredefinida clonar() {
        CombinacaoPredefinida copia = new CombinacaoPredefinida(
                this.nomeCombo, this.lanche, this.acompanhamento, this.bebida, this.preco);
        copia.observacoes = new ArrayList<>(this.observacoes);
        return copia;
    }

    public void adicionarObservacao(String observacao) {
        this.observacoes.add(observacao);
    }

    public void setNomeCombo(String nomeCombo) {
        this.nomeCombo = nomeCombo;
    }

    public void trocarBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getNomeCombo() {
        return nomeCombo;
    }

    public String getLanche() {
        return lanche;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public String getBebida() {
        return bebida;
    }

    public List<String> getObservacoes() {
        return observacoes;
    }

    public double getPreco() {
        return preco;
    }
}
