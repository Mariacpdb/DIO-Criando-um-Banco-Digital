# DIO-Criando-um-Banco-Digital
Criando um Banco Digital

# Sistema Bancário em Java

Este projeto é uma implementação de um sistema bancário simples usando conceitos de Programação Orientada a Objetos (POO) em Java. O sistema permite aos usuários criar dois tipos de contas (Corrente e Poupança) e realizar operações básicas como depósito, saque e transferência entre contas.

## Funcionalidades

- **Conta Corrente**:
  - Depósito
  - Saque com taxa
  - Transferência com taxa

- **Conta Poupança**:
  - Depósito
  - Saque
  - Transferência

## Estrutura do Projeto

O projeto está estruturado nas seguintes classes:

- `Conta`: Classe abstrata que define a interface comum para contas.
- `ContaCorrente`: Implementa a classe `Conta` com funcionalidades específicas para uma conta corrente.
- `ContaPoupanca`: Implementa a classe `Conta` com funcionalidades específicas para uma conta poupança.
- `Banco`: Classe principal que demonstra o uso das contas.

## Diagrama UML

Aqui está um diagrama UML que representa a estrutura do sistema:

```mermaid
classDiagram
    class Conta {
        +String numero
        +double saldo
        +depositar(double valor)
        +sacar(double valor)
        +transferir(double valor, Conta contaDestino)
    }

    class ContaCorrente {
        +double TAXA_SAQUE
        +depositar(double valor)
        +sacar(double valor)
        +transferir(double valor, Conta contaDestino)
    }

    class ContaPoupanca {
        +depositar(double valor)
        +sacar(double valor)
        +transferir(double valor, Conta contaDestino)
    }

    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca
