package com.hamburgueria.relatorio;

public interface RelatorioVisitor {
    void visitar(LancheItem item);
    void visitar(BebidaItem item);
    void visitar(AcompanhamentoItem item);
}
