package com.hamburgueria.structural.adapter;

/**
 * Padrao ADAPTER.
 *
 * Converte a interface de GatewayPagamentoExterno (que trabalha com valores
 * em centavos e retorna Strings de status) na interface ProcessadorPagamento
 * esperada internamente pelo sistema (que trabalha com double e retorna
 * boolean). Permite reaproveitar o SDK de terceiros sem alterar seu codigo
 * nem o codigo cliente que ja depende de ProcessadorPagamento.
 */
public class AdaptadorGatewayExterno implements ProcessadorPagamento {

    private final GatewayPagamentoExterno gatewayExterno;

    public AdaptadorGatewayExterno(GatewayPagamentoExterno gatewayExterno) {
        this.gatewayExterno = gatewayExterno;
    }

    @Override
    public boolean processarPagamento(double valor) {
        int valorEmCentavos = (int) Math.round(valor * 100);
        String resultado = gatewayExterno.executarCobranca(valorEmCentavos);
        return "SUCESSO".equals(resultado);
    }
}
