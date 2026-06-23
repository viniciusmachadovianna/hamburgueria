package com.hamburgueria.structural.adapter;

/**
 * Classe existente de terceiros (Adaptee) com uma interface incompativel
 * com a usada internamente pelo sistema da hamburgueria. Simula um SDK de
 * gateway de pagamento externo que a equipe nao pode modificar.
 */
public class GatewayPagamentoExterno {

    public String executarCobranca(int valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            return "FALHA";
        }
        System.out.printf("[Gateway Externo] Cobranca de %d centavos executada.%n", valorEmCentavos);
        return "SUCESSO";
    }
}
