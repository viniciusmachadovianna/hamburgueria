package com.hamburgueria.structural.adapter;

public class GatewayPagamentoExterno {

    public String executarCobranca(int valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            return "FALHA";
        }
        System.out.printf("[Gateway Externo] Cobranca de %d centavos executada.%n", valorEmCentavos);
        return "SUCESSO";
    }
}
