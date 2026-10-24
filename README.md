# Sistema de Agendamento

## Sumário

* [Introdução](#introdução)

* [Estrutura de Diretórios](#estrutura-de-diretórios)

* [Compilar e executar](#compilar-e-executar)

* [Como gerar a documentação de API](#como-gerar-a-documentação-de-api)

* [Integrantes](#integrantes)

## Introdução

Este sistema é projetado para o gerenciamento completo de agendamentos e horários em um ambiente clínico. A aplicação oferece funcionalidades de controle de atendimentos, incluindo o registro de horários, cálculo de durações, validações dos horários e durações e prevenção de conflitos de agenda de acordo com as regras de negócio.

## Estrutura de Diretórios

A organização do código-fonte segue a estrutura padrão abaixo:

```
src/
└── main/
    ├── Main.java
    ├── exceptions/
    │   ├── DuracaoInvalidaException.java
    │   ├── HorarioInvalidoException.java
    │   └── HorarioOcupadoException.java
    ├── tests/
    │   ├── TesteAgendaBase.java
    │   ├── TesteDuracaoAtendimento.java
    │   └── TesteFormatoHorario.java
    └── utils/
        ├── AgendaBase.java
        ├── Atendimento.java
        ├── DuracaoAtendimento.java
        ├── Horario.java
        └── HorarioAtendimento.java

```

## Compilar e Executar

### Windows / Unix

```bash
# 1) clonar projeto
git clone (link do projeto)

# 2) entrar na pasta do projeto
cd (pasta do projeto)

# 3) compilar projeto
javac -d bin -sourcepath src/main src/main/Main.java

# 4) executar projeto
java -cp bin Main
```

## Como gerar a documentação de API

Dentro da pasta raíz do projeto, execute os seguintes comandos no terminal:

```bash
javadoc -d docs -sourcepath src\main src\main\Main.java -subpackages exceptions:tests:utils
```

## Integrantes

- Gabriel Pinheiro Maia (20250036420)
- Pedro Augusto Carvalho de Freitas Gouveia Fidalgo (20250036493)
- Victor Matheus de Abreu Dantas (20250040208)
