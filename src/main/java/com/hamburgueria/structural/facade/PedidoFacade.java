package com.hamburgueria.structural.facade;

/**
 * Padrao FACADE.
 *
 * Fornece uma interface unica e simplificada (fecharPedido) para um
 * conjunto de subsistemas complexos e independentes (Estoque, Cozinha,
 * Pagamento, Notificacao). O cliente (ex.: tela de caixa) nao precisa saber
 * a ordem correta de chamadas nem conhecer os detalhes de cada subsistema;
 * basta interagir com a fachada.
 */
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

    // Construtor para injecao de dependencias em testes (permite usar dublês/mocks simples)
    public PedidoFacade(EstoqueSubsistema estoque, CozinhaSubsistema cozinha,
                         PagamentoSubsistema pagamento, NotificacaoSubsistema notificacao) {
        this.estoque = estoque;
        this.cozinha = cozinha;
        this.pagamento = pagamento;
        this.notificacao = notificacao;
    }

    /**
     * Operacao simplificada que orquestra todo o fluxo de fechamento de um
     * pedido, escondendo a complexidade da interacao entre subsistemas.
     */
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
