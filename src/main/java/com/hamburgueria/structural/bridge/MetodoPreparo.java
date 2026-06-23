package com.hamburgueria.structural.bridge;

/**
 * Implementor do BRIDGE: define a interface para as diferentes formas de
 * preparo (a "implementacao") que podem ser combinadas com qualquer tipo
 * de lanche (a "abstracao"), de forma independente.
 */
public interface MetodoPreparo {
    String preparar(String nomeIngredientePrincipal);
}
