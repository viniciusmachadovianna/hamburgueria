package com.hamburgueria.desconto;

public abstract class AprovadorDesconto {

    private AprovadorDesconto proximo;

    public void setProximo(AprovadorDesconto proximo) {
        this.proximo = proximo;
    }

    public final String processar(double percentualDesconto) {
        if (podeAprovar(percentualDesconto)) {
            return String.format("%s aprovou desconto de %.0f%%", nomeCargo(), percentualDesconto * 100);
        }
        if (proximo != null) {
            return proximo.processar(percentualDesconto);
        }
        return "Nenhum aprovador disponivel para autorizar este desconto";
    }

    protected abstract boolean podeAprovar(double percentual);

    protected abstract String nomeCargo();
}
