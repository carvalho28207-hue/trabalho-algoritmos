# Trabalho Avaliativo — Algoritmos e Programação

**Tema:** Um algoritmo, diferentes linguagens: listas, arrays e repetições

**Aluno:** Enzo Carvalho de Andrade 
**RA:** [Registro acadêmico]  
**Professor:** Alexandre de Oliveira — Montanha  
**Data:** 01/11/2026

## Objetivo

O objetivo é compreender como arrays, listas e laços de repetição trabalham 
juntos e reconhecer como um mesmo raciocínio pode ser representado em 
diferentes linguagens

## Linguagens utilizadas

- Java — JDK 25.0.2
- C# — .NET SDK 10.0.403
- Rust — Rustc 1.99.1

## Organização do projeto

- `java/` — Implementação Java
- `csharp/` — Implementação C#
- `rust/` — Implementação Rust
- `evidencias/` — Registros dos testes
- `relatorio.md` — Relatório da atividade

## Como executar

Todos os comandos partem da raiz do repositório. Cada programa mostra os times, as duas tabelas com 4 times e, depois de acrescentar o Tombense, as duas tabelas com 5 times.

### Java

```
cd java
javac -encoding UTF-8 Confrontos.java
java -Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 Confrontos
```

Os arquivos `.class` gerados não são versionados. No PowerShell, coloque os argumentos `-D...` entre aspas.

### C#

```
cd csharp
dotnet run
```

### Rust

```
cd rust
cargo run
```

## Saídas e relatório

As saídas reais das execuções estão em `evidencias/`. O relatório completo está em `relatorio.md`.

