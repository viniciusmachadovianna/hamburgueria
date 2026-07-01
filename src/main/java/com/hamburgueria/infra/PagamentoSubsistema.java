package com.hamburgueria.infra;

public class PagamentoSubsistema {

    public boolean cobrar(double valor) {
        System.out.printf("[Pagamento] Cobrando R$ %.2f...%n", valor);
        return valor > 0;
    }
}
