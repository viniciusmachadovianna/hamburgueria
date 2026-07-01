package com.hamburgueria.pagamento;

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
