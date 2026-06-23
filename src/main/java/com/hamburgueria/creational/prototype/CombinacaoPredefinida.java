package com.hamburgueria.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Prototipo concreto: um combo pre-definido (lanche + acompanhamento +
 * bebida) que pode ser clonado para originar novos combos personalizados
 * sem afetar o combo "modelo" original.
 */
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

    /**
     * Clone PROFUNDO: a lista de observacoes e copiada para uma nova lista,
     * garantindo que alteracoes no clone nao afetem o prototipo original.
     */
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
