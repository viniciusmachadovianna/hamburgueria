package com.hamburgueria.infra;

import com.hamburgueria.estado.EstoqueSubsistema;

public class PedidoFacade {

    private final EstoqueSubsistema estoque;
    private final CozinhaSubsistema cozinha;
    private final PagamentoSubsistema pagamento;
    private final NotificacaoSubsistema notificacao;

    public PedidoFacade() {
        this.estoque = new EstoqueSubsistema();
        this.cozinha = new CozinhaSubsistema();
        this.pagamento = new PagamentoSubsistema();
        this.notificacao = new NotificacaoSubsistema();
    }

    public PedidoFacade(EstoqueSubsistema estoque, CozinhaSubsistema cozinha,
                         PagamentoSubsistema pagamento, NotificacaoSubsistema notificacao) {
        this.estoque = estoque;
        this.cozinha = cozinha;
        this.pagamento = pagamento;
        this.notificacao = notificacao;
    }

    public boolean fecharPedido(String ingredientePrincipal, String descricaoPedido, double valorTotal) {
        if (!estoque.verificarDisponibilidade(ingredientePrincipal, 1)) {
            notificacao.notificarCliente("Pedido indisponivel: " + ingredientePrincipal + " em falta.");
            return false;
        }

        boolean pagamentoAprovado = pagamento.cobrar(valorTotal);
        if (!pagamentoAprovado) {
            notificacao.notificarCliente("Falha no pagamento do pedido.");
            return false;
        }

        estoque.darBaixa(ingredientePrincipal, 1);
        cozinha.prepararPedido(descricaoPedido);
        notificacao.notificarCliente("Pedido confirmado e em preparo!");
        return true;
    }
}
