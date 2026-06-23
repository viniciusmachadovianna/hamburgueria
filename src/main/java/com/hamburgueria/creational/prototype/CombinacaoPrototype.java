package com.hamburgueria.creational.prototype;

/**
 * Padrao PROTOTYPE.
 *
 * Permite criar novos objetos copiando uma instancia existente (prototipo)
 * em vez de criar do zero, util quando a criacao "do zero" e custosa ou
 * quando queremos partir de um estado configurado e ajustar pequenas
 * variacoes.
 *
 * No dominio: a hamburgueria mantem "combos modelo" prontos (ex.: Combo
 * Familia) que podem ser clonados e levemente ajustados para um pedido
 * especifico, sem reconstruir toda a combinacao de itens manualmente.
 */
public interface CombinacaoPrototype extends Cloneable {
    CombinacaoPrototype clonar();
}
