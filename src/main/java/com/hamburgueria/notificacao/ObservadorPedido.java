package com.hamburgueria.notificacao;

public interface ObservadorPedido {
    void atualizar(int numeroPedido, String novoStatus);
}
