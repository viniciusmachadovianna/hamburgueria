package com.hamburgueria.behavioral.interpreter;

public class CupomInterpretadorContexto {

    private static final double VALOR_FRETE_PADRAO = 8.00;

    public ExpressaoCupom interpretarCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo de cupom invalido");
        }

        String upper = codigo.trim().toUpperCase();

        if (upper.matches("\\d+PORCENTO")) {
            int percentual = Integer.parseInt(upper.replace("PORCENTO", ""));
            return new DescontoPercentualExpressao(percentual / 100.0);
        }

        if (upper.startsWith("FRETEGRATIS")) {
            String resto = upper.replace("FRETEGRATIS", "");
            double frete = resto.isBlank() ? VALOR_FRETE_PADRAO : Double.parseDouble(resto);
            return new FreteGratisExpressao(frete);
        }

        throw new IllegalArgumentException("Cupom nao reconhecido: " + codigo);
    }
}
