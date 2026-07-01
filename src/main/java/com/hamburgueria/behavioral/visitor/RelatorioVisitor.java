package com.hamburgueria.behavioral.visitor;

public interface RelatorioVisitor {
    void visitar(LancheItem item);
    void visitar(BebidaItem item);
    void visitar(AcompanhamentoItem item);
}
