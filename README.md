# Hamburgueria
Sistema de Hamburgueria em Java como trabalho final de "Design Patterns" da disciplina de "Arquitetura e Projeto de Software" na graduação em Engenharia de Software

**Comando:** 
> Aplicar todos os 23 padrões de projeto em um **Sistema de atendimento fastfood para Hamburgueria** usando Java Maven + JUnit

**Referências técnicas principais:** [Refactoring Guru](https://refactoring.guru/design-patterns/) e [Repositório do professor](https://github.com/marcoaparaujo/padroes-projeto)

**Dependências e versões utilizadas:**
- Java v21.0.11
- JUnit Jupiter v5.10.2
- Maven (Compilador) v21
- Maven Surefire plugin v3.2.5

---

## Padrões e diagramas

| # | Padrão (Categoria) | Classes principais no domínio |
| :-: | :--- | :--- |
| 1 | Singleton (Criacional)                        | CaixaRegistradora |
| 2 | Factory Method (Criacional)                   | FabricaLanche |
| 3 | Abstract Factory (Criacional)                 | FabricaIngredientes |
| 4 | Builder (Criacional)                          | LancheBuilder + CardapioDirector |
| 5 | Prototype (Criacional)                        | CombinacaoPredefinida + RegistroCombos |
| 6 | Adapter (Estrutural)                          | AdaptadorGatewayExterno |
| 7 | Bridge (Estrutural)                           | ItemMenu × MetodoPreparo |
| 8 | Composite (Estrutural)                        | ItemCardapio |
| 9 | Decorator (Estrutural)                        | LancheDecorator |
| 10 | Facade (Estrutural)                          | PedidoFacade |
| 11 | Flyweight (Estrutural)                       | TipoIngrediente + FabricaIngredientesFlyweight |
| 12 | Proxy (Estrutural)                           | ProxyEstoque |
| 13 | Chain of Responsibility (Comportamental)     | AprovadorDesconto |
| 14 | Command (Comportamental)                     | PedidoCommand + Garcom |
| 15 | Interpreter (Comportamental)                 | ExpressaoCupom |
| 16 | Iterator (Comportamental)                    | CardapioIterator |
| 17 | Mediator (Comportamental)                    | AtendimentoMediator / CentralAtendimento |
| 18 | Memento (Comportamental)                     | PedidoMemento + HistoricoPedido |
| 19 | Observer (Comportamental)                    | PedidoObservavel + observadores |
| 20 | State (Comportamental)                       | EstadoPedido |
| 21 | Strategy (Comportamental)                    | EstrategiaEntrega |
| 22 | Template Method (Comportamental)             | PreparoLanche |
| 23 | Visitor (Comportamental)                     | RelatorioVisitor |

### Diagramas

#### Resumo técnico - Notação UML

##### Atributos e Métodos
| Símbolo | Nome | Descrição |
| :---: | :--- | :--- |
| **`+`** | Público / Public | O elemento é visível por qualquer outra classe. |
| **`-`** | Privado / Private | O elemento só pode ser acessado de dentro da própria classe. |
| **`#`** | Protegido / Protected | Visível apenas para a própria classe e suas subclasses (herança). |
| **`~`** | Pacote / Package | Visível apenas por classes dentro do mesmo pacote (package-private). |

##### Relacionamentos (Linhas e Setas)
| Elemento Visual | Linha | Seta | Significado |
| :---: | :--- | :--- | :--- |
| **`——-—▷`** | Contínua | Triangular, Fechada e Vazia | Herança / Extensão |
| **`-- - ▷`** | Tracejada | Triangular, Fechada e Vazia | Implementação |
| **`——-—>`** | Contínua | Aberta (em "V") | Associação Direcionada |
| **`-- - >`** | Tracejada | Aberta (em "V") | Dependência |
| **`♢——-—`** | Contínua | Losango Vazio (na origem) | Agregação |
| **`♦——-—`** | Contínua | Losango Preenchido (na origem) | Composição |

##### Multiplicidade
| Notação | Significado | Descrição |
| :---: | :--- | :--- |
| **`1`** | Exatamente uma instância | Obrigatório e exclusivo |
| **`0..1`** | Zero ou uma instância | Opcional |
| **`*`** ou **`0..*`** | Zero ou múltiplas instâncias | Lista aberta que pode ser vazia |
| **`1..*`** | Uma ou múltiplas instâncias | Obrigatório ao menos uma |

#### Diagrama geral
![Diagrama UML Hamburgueria](diagrams/hamburgueria.png)

![Diagrama de estados](diagrams/estados.png)

#### Diagramas por padrão
##### Criacionais (Total: 5)
Mecanismos de criação de objetos, tentando criar objetos de forma adequada à situação.

01. Singleton
> Função: garantir que uma classe tenha **apenas uma instância** e fornecer um ponto de acesso global a ela.

![Diagrama UML Singleton](diagrams/singleton.png) \
[Ref. visual Singleton](https://refactoring.guru/design-patterns/singleton)

02. Factory Method
> Função: definir uma **interface para criar** um objeto, mas deixar subclasses definirem qual classe instanciar.

![Diagrama UML Factory Method](diagrams/factoryMethod.png) \
[Ref. visual Factory Method](https://refactoring.guru/design-patterns/factory-method)

03. Abstract Factory
> Função: fornecer uma interface para **relacionar** objetos sem especificar suas classes concretas.

![Diagrama UML Abstract Factory](diagrams/abstractFactory.png) \
[Ref. visual Abstract factory](https://refactoring.guru/design-patterns/abstract-factory)

04. Builder
> Função: separar a construção de um **objeto complexo**, permitindo criar diferentes representações usando o mesmo processo de construção.

![Diagrama UML Builder](diagrams/builder.png) \
[Ref. visual Builder](https://refactoring.guru/design-patterns/builder)

05. Prototype
> Função: especificar os tipos de **objetos a serem copiados** através de um protótipo.

![Diagrama UML Prototype](diagrams/prototype.png) \
[Ref. visual Prototype](https://refactoring.guru/design-patterns/prototype)

##### Estruturais (Total: 7)
Composição de classes e objetos que formam estruturas maiores, flexíveis e mais eficientes.

06. Adapter
> Função: **converter** / "adaptar" interfaces, permitindo que classes incompatíveis trabalhem juntas.

![Diagrama UML Adapter](diagrams/adapter.png) \
[Ref. visual Adapter](https://refactoring.guru/design-patterns/adapter)

07. Bridge
> Função: **desacopla** a abstração da implementação para permitir variações independentes.

![Diagrama UML Bridge](diagrams/bridge.png) \
[Ref. visual Bridge](https://refactoring.guru/design-patterns/bridge)

08. Composite
> Função: compor objetos em **estruturas de árvore** para representar hierarquias parte-todo, permitindo tratar objetos individuais e composições de forma parecida.

![Diagrama UML Composite](diagrams/composite.png) \
[Ref. visual Composite](https://refactoring.guru/design-patterns/composite)

09. Decorator
> Função: dá responsabilidades **adicionais** a um objeto dinamicamente, é uma alternativa à herança.

![Diagrama UML Decorator](diagrams/decorator.png) \
[Ref. visual Decorator](https://refactoring.guru/design-patterns/decorator)

10. Facade
> Função: uma **interface simplificada** de um conjunto de interfaces para facilitar o uso.

![Diagrama UML Facade](diagrams/facade.png) \
[Ref. visual Facade](https://refactoring.guru/design-patterns/facade)

11. Flyweight
> Função: suportar **grandes quantidades de objetos** usando compartilhamento de elementos em comum.

![Diagrama UML Flyweight](diagrams/flyweight.png) \
[Ref. visual Flyweight](https://refactoring.guru/design-patterns/flyweight)

12. Proxy
> Função: **controlar o acesso** a um objeto através de um marcador / substituto.

![Diagrama UML Proxy](diagrams/proxy.png) \
[Ref. visual Proxy](https://refactoring.guru/design-patterns/proxy)

##### Comportamentais (Total: 11)

13. Chain of Responsibility
> Função: **encadeia** uma solicitação até "alguém" tratar

![Diagrama UML Chain of Responsibility](diagrams/chainOfResponsibility.png) \
[Ref. visual Chain of Responsibility](https://refactoring.guru/design-patterns/chain-of-responsibility)

14. Command
> Função: encapsular uma solicitação, permitindo **parametrizar / enfileirar /  registrar operações**, suportando inclusive que elas possam ser desfeitas.

![Diagrama UML Command](diagrams/command.png) \
[Ref. visual Command](https://refactoring.guru/design-patterns/command)

15. Interpreter
> Função: usar uma "representação gramática" para **interpretar sentenças de linguagem**.

![Diagrama UML Interpreter](diagrams/interpreter.png) \
(Não há referência desse padrão no Refactoring Guru)

16. Iterator
> Função: acessar elementos de um objeto agregado sem expor a representação interna.

![Diagrama UML Iterator](diagrams/iterator.png) \
[Ref. visual Iterator](https://refactoring.guru/design-patterns/iterator)

17. Mediator
> Função: **determina como um conjunto de objetos interage**, evitando que objetos se refiram uns aos outros explicitamente.

![Diagrama UML Mediator](diagrams/mediator.png) \
[Ref. visual Mediator](https://refactoring.guru/design-patterns/mediator)

18. Memento
> Função: capturar o estado de um objeto para que ele possa ser restaurado quando necessário, sem violar encapsulamento.

![Diagrama UML Memento](diagrams/memento.png) \
[Ref. visual Memento](https://refactoring.guru/design-patterns/memento)

19. Observer
> Função: quando um objeto muda de estado, notifica os dependentes para que atualizem automaticamente.

![Diagrama UML Observer](diagrams/observer.png) \
[Ref. visual Observer](https://refactoring.guru/design-patterns/observer)

20. State
> Função: **altera o comportamento de um objeto** quando seu estado muda, "parecendo" que o objeto mudou de classe.

![Diagrama UML State](diagrams/state.png) \
[Ref. visual State](https://refactoring.guru/design-patterns/state)

21. Strategy
> Função: define um conjunto de algoritmos (estratégias) que podem ser alternados, permitindo que o algoritmo varie independentemente dos que o cliente utilizar.

![Diagrama UML Strategy](diagrams/strategy.png) \
[Ref. visual Strategy](https://refactoring.guru/design-patterns/strategy)

22. Template Method
> Função: é o esqueleto de um algoritmo, deixando alguns pontos para as subclasses definirem, sem alterar a estrutura geral.

![Diagrama UML Template Method](diagrams/templateMethod.png) \
[Ref. visual Template Method](https://refactoring.guru/design-patterns/template-method)

23. Visitor
> Função: uma operação executada em uma lista de objetos, permitindo definir novas operações sem mudar as classes desses elementos.

![Diagrama UML Visitor](diagrams/visitor.png) \
[Ref. visual Visitor](https://refactoring.guru/design-patterns/visitor)
