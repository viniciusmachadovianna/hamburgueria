# Hamburgueria
> Sistema de Hamburgueria em Java como trabalho final de "Design Patterns" da disciplina de "Arquitetura e Projeto de Software" na graduação em Engenharia de Software \

**Referências técnicas principais:** [Refactoring Guru](https://refactoring.guru/design-patterns/) e [Repositório do professor](https://github.com/marcoaparaujo/padroes-projeto)

**Comando:** Aplicar todos os 23 padrões de projeto em um **Sistema de atendimento fastfood para Hamburgueria** usando Java Maven + JUnit

---

## Padrões e diagramas

| Categoria | Quantidade | Padrões |
| :--- | :---: | :--- |
| **Criacionais** | 5 | Singleton, Factory Method, Abstract Factory, Builder, Prototype |
| **Estruturais** | 7 | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy |
| **Comportamentais** | 11 | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor |

### Lista distribuída de Padrão x Classe
| # | Categoria | Padrão | Classes principais no domínio |
| :-: | :--- | :--- | :--- |
| 1 | Criacional | Singleton | CaixaRegistradora |
| 2 | Criacional | Factory Method | FabricaLanche + subclasses |
| 3 | Criacional | Abstract Factory | FabricaIngredientes |
| 4 | Criacional | Builder | LancheBuilder + CardapioDirector |
| 5 | Criacional | Prototype | CombinacaoPredefinida + RegistroCombos |
| 6 | Estrutural | Adapter | AdaptadorGatewayExterno |
| 7 | Estrutural | Bridge | ItemMenu × MetodoPreparo |
| 8 | Estrutural | Composite | ItemCardapio |
| 9 | Estrutural | Decorator | LancheDecorator |
| 10 | Estrutural | Facade | PedidoFacade |
| 11 | Estrutural | Flyweight | TipoIngrediente + FabricaIngredientesFlyweight |
| 12 | Estrutural | Proxy | ProxyEstoque |
| 13 | Comportamental | Chain of Responsibility | AprovadorDesconto |
| 14 | Comportamental | Command | PedidoCommand + Garcom |
| 15 | Comportamental | Interpreter | ExpressaoCupom |
| 16 | Comportamental | Iterator | CardapioIterator |
| 17 | Comportamental | Mediator | AtendimentoMediator / CentralAtendimento |
| 18 | Comportamental | Memento | PedidoMemento + HistoricoPedido |
| 19 | Comportamental | Observer | PedidoObservavel + observadores |
| 20 | Comportamental | State | EstadoPedido |
| 21 | Comportamental | Strategy | EstrategiaEntrega |
| 22 | Comportamental | Template Method | PreparoLanche |
| 23 | Comportamental | Visitor | RelatorioVisitor |

### Diagramas

![Diagrama UML Hamburgueria](diagrama_hamburgueria.png)
