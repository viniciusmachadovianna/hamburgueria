package com.hamburgueria.combo;

import java.util.HashMap;
import java.util.Map;

public class RegistroCombos {

    private final Map<String, CombinacaoPredefinida> combosModelo = new HashMap<>();

    public RegistroCombos() {
        combosModelo.put("FAMILIA", new CombinacaoPredefinida(
                "Combo Familia", "4x X-Burguer", "Batata grande", "Refrigerante 2L", 89.90));
        combosModelo.put("INDIVIDUAL", new CombinacaoPredefinida(
                "Combo Individual", "X-Salada", "Batata media", "Refrigerante lata", 32.90));
    }

    public CombinacaoPredefinida obterCopia(String chave) {
        CombinacaoPredefinida modelo = combosModelo.get(chave);
        if (modelo == null) {
            throw new IllegalArgumentException("Combo modelo nao encontrado: " + chave);
        }
        return modelo.clonar();
    }
}
