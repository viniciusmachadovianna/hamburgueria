package com.hamburgueria.creational.abstractfactory;

/**
 * Padrao ABSTRACT FACTORY.
 *
 * Declara uma interface para criar familias de produtos relacionados
 * (Pao + MolhoEspecial) sem especificar suas classes concretas. Cada
 * "linha de produto" da hamburgueria (Gourmet, Tradicional) implementa essa
 * fabrica garantindo que os ingredientes combinados sejam sempre compativeis
 * entre si (ex.: nunca misturar pao brioche da linha gourmet com molho
 * barbecue da linha tradicional por engano).
 */
public interface FabricaIngredientes {
    Pao criarPao();
    MolhoEspecial criarMolho();
}
