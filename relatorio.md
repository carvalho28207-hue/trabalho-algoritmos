# Relatório — Algoritmos e Programação

## Identificação

**Aluno:** Enzo Carvalho de Andrade  
**RA:** [Registro acadêmico]  
**Professor:** Alexandre de Oliveira — Montanha

## 1. Análise da aula gravada

### Questão 1 — Por que utilizamos laços de repetição?

**Resposta: Para não termos que rodar um mesmo programa toda vez, 10:07**

### Questão 2 — Diferença entre while e do-while

**Resposta: While roda enquanto uma condição for verdadeira 10:54 
            Do While executa pelo menos uma vez, porque a sua condição está no final 15:54**

Exemplo em que a diferença importa: pedir uma senha ao usuário. Com `do-while`, o programa pede a senha pelo menos uma vez e repete enquanto ela estiver incorreta (`do { ler senha } while (senha != correta);`). Com `while`, a condição seria testada antes de qualquer leitura, quando ainda não existe senha digitada, então seria preciso ler uma primeira vez fora do laço.

### Questão 3 — Dois laços no exemplo dos times em C#

**Resposta: Precisa porque os times tem que jogar mas de uma vez e não podem jogar contra eles mesmo  31:12**

### Questão 4 — Função da condição if

**Resposta: if (i != j)   34:47**

### Questão 5 — Comparação entre Java, C# e Rust

**Resposta: Diferença 1: o comando de exibir na tela muda em cada linguagem.
            Diferença 2: a forma do for. Java e C# usam início, condição e incremento. O Rust usa um intervalo 0..3 com o fim excluído.
            Conceito que permanece: um bloco se repete enquanto um contador, que começa em 0 vai aumenetando, não chega ao limite. A contagem a partir do 0, que combina com os índices da coleção de times, também é igual nas três.**

**Referências da gravação:** https://youtu.be/JzwH1EVyO1Q


## 2. Leitura e relação com o livro

Não fiz

### Questão 1 — Como os elementos de um array são organizados e acessados?

Os elementos ficam lado a lado na memória, em posições contíguas, e todos têm o mesmo tamanho. Cada elemento tem um índice, que começa em 0. Como a posição de qualquer elemento pode ser calculada a partir do endereço do primeiro e do índice, o acesso por índice (`times[i]`) é direto, sem percorrer os anteriores. Neste trabalho, os quatro times ocupam os índices 0 a 3.

### Questão 2 — Como os elementos de uma lista encadeada são organizados?

Os elementos podem estar em qualquer lugar da memória. Cada elemento guarda o seu dado e o endereço do próximo. Para chegar ao terceiro elemento é preciso passar pelo primeiro e pelo segundo.

```
 início
   |
   v
[Atlético-MG | •]--->[Cruzeiro | •]--->[América-MG | •]--->[Villa Nova | null]
```

### Questão 3 — Por que inserir ou excluir pode exigir operações diferentes?

No array, os elementos são contíguos e o tamanho é fixo. Para acrescentar além do espaço reservado é preciso criar outro array maior e copiar os elementos. Inserir ou remover no meio também obriga a deslocar os elementos seguintes. Na lista encadeada, inserir ou excluir muda apenas os "ponteiros" dos vizinhos, sem deslocar os demais, mas o acesso por posição é sequencial.

### Questão 4 — Uma coleção chamada "lista" é necessariamente uma lista encadeada?

Não.

- **`List<string>` (C#):** é uma lista dinâmica, que guarda os elementos em um array interno e o redimensiona quando falta espaço. A lista encadeada em C# é outra classe, `LinkedList<T>`.
- **`Vec<String>` (Rust):** é um vetor dinâmico, com elementos contíguos e capacidade que cresce quando necessário. A lista encadeada em Rust é outra estrutura, `LinkedList`, e raramente é a escolha usual.

Por isso, "lista" pelo nome não significa lista encadeada. Array, lista dinâmica e lista encadeada são coisas diferentes.

### Questão 5 — Vantagens de uma estrutura baseada em array para este problema

- O acesso por índice é direto, e os laços aninhados usam justamente índices (`i`, `j`).
- A ordem dos times é mantida e a contagem a partir de 0 combina com o `for`.
- A quantidade de elementos é consultada de forma simples (`length`, `Count`, `len()`).
- O RF-05 (turno único) é resolvido apenas comparando índices (`i < j`), sem coleção auxiliar.
- Como o conjunto de times é pequeno e é percorrido várias vezes, a leitura sequencial de elementos contíguos é natural.

**Referências oficiais pesquisadas (o aluno deve confirmar que abrem):**
- Documentação Microsoft: `List<T>` — https://learn.microsoft.com/dotnet/api/system.collections.generic.list-1
- Documentação Microsoft: `LinkedList<T>` — https://learn.microsoft.com/dotnet/api/system.collections.generic.linkedlist-1
- Documentação Rust: `Vec` — https://doc.rust-lang.org/std/vec/struct.Vec.html

## 3. Desafio prático — código e evidências

Códigos (os três têm RF-01 a RF-06 com 4 times e, depois, a Parte 4):

- Java: [java/Confrontos.java](java/Confrontos.java) (array de `String`)
- C#: [csharp/Program.cs](csharp/Program.cs) (`List<string>`)
- Rust: [rust/src/main.rs](rust/src/main.rs) (`Vec<String>`)

Saídas reais das execuções, em UTF-8, cada arquivo com o comando que o gerou na segunda linha:

- [evidencias/java_saida.txt](evidencias/java_saida.txt)
- [evidencias/csharp_saida.txt](evidencias/csharp_saida.txt)
- [evidencias/rust_saida.txt](evidencias/rust_saida.txt)
- [evidencias/tres_times_saida.txt](evidencias/tres_times_saida.txt) — execução com 3 times, feita a partir de cópias temporárias dos códigos (o repositório mantém 4 e 5 times).

Capturas de tela: PREENCHER PELO ALUNO (ver a lista entregue no fim da sessão).

## 4. Alteração da coleção

Depois das duas tabelas com 4 times, foi incluído **Tombense** e as tabelas foram geradas de novo, no mesmo arquivo de cada linguagem.

| Linguagem | Como o time foi acrescentado |
|---|---|
| Java | `String[] timesNovos = new String[5];`, cópia dos 4 elementos com `for` e `timesNovos[4] = "Tombense";` |
| C# | `times.Add("Tombense");` |
| Rust | `times.push(String::from("Tombense"));` |

Resultado com 5 times, nas três linguagens: 20 jogos de ida e volta e 10 em turno único.

### Questão 1 — Por que o array de Java exigiu a criação de outro array?

Porque o array tem tamanho fixo definido na criação (4 posições). Não é possível ampliá-lo. Foi preciso criar um array com 5 posições, copiar os 4 times com um laço e só então colocar o Tombense na última posição.

### Questão 2 — O que ficou mais simples com `List<string>` e `Vec<String>`?

Acrescentar o elemento: uma única chamada (`Add` ou `push`), sem criar outra coleção nem copiar manualmente. O redimensionamento é feito pela própria estrutura.

### Questão 3 — A facilidade de adicionar significa que são listas encadeadas?

Não. `List<string>` usa um array interno e `Vec<String>` usa memória contígua, ambos com crescimento automático: quando falta espaço, a estrutura aloca um espaço maior e copia, de forma interna. Isso está descrito na documentação oficial listada na Parte 2. O acesso por índice continua direto, o que não é característica de lista encadeada.

## 5. Comparação das sintaxes

| Operação | Java | C# | Rust |
|---|---|---|---|
| Criar a coleção | `String[] times = { "Atlético-MG", "Cruzeiro", "América-MG", "Villa Nova"};` | `List<string> times = new List<string> { "Atlético-MG", "Cruzeiro", "América-MG", "Villa Nova" };` | `let mut times: Vec<String> = vec![ String::from("Atlético-MG"), ... ];` |
| Consultar a quantidade | `times.length` | `times.Count` | `times.len()` |
| Acessar um elemento pelo índice | `times[i]` | `times[i]` | `times[i]` |
| Laço para percorrer | `for (int i = 0; i < times.length; i++)` | `for (int i = 0; i < times.Count; i++)` | `for i in 0..times.len()` |
| Dois laços aninhados | `for (int i = ...) { for (int j = ...) { ... } }` | `for (int i = ...) { for (int j = ...) { ... } }` | `for i in 0..times.len() { for j in 0..times.len() { ... } }` |
| Impedir confronto contra o próprio time | `if (i != j)` | `if (i != j)` | `if i != j` |
| Acrescentar o quinto time | `String[] timesNovos = new String[5];` + `for` copiando + `timesNovos[4] = "Tombense";` | `times.Add("Tombense");` | `times.push(String::from("Tombense"));` |

**O que mudou na escrita e o que permaneceu igual no raciocínio?**

Mudou a escrita: o tipo da coleção, a forma de pedir a quantidade (`length`, `Count`, `len()`), o comando de exibir, o `for` (início, condição e incremento em Java e C#; intervalo `0..n` em Rust), a declaração de variáveis (`int`, `let mut`) e o modo de acrescentar um elemento. Permaneceu igual o raciocínio: guardar os times em uma coleção indexada a partir de 0, percorrê-la com dois laços aninhados, usar `i != j` para impedir o time de jogar contra si mesmo, usar `i < j` para ter cada par uma única vez, e contar os jogos efetivamente exibidos.

## 6. Teste de mesa e validação

### Teste de mesa da tabela de ida e volta com 3 times

Times: 0 = Atlético-MG, 1 = Cruzeiro, 2 = América-MG.

| Índice do primeiro time | Índice do segundo time | Combinação examinada | Exibe o jogo? Por quê? |
|---|---|---|---|
| 0 | 0 | Atlético-MG x Atlético-MG | Não. `i == j`, o time contra ele mesmo. |
| 0 | 1 | Atlético-MG x Cruzeiro | Sim. `i != j`. (jogo 1) |
| 0 | 2 | Atlético-MG x América-MG | Sim. `i != j`. (jogo 2) |
| 1 | 0 | Cruzeiro x Atlético-MG | Sim. `i != j`, mando invertido. (jogo 3) |
| 1 | 1 | Cruzeiro x Cruzeiro | Não. `i == j`. |
| 1 | 2 | Cruzeiro x América-MG | Sim. `i != j`. (jogo 4) |
| 2 | 0 | América-MG x Atlético-MG | Sim. `i != j`. (jogo 5) |
| 2 | 1 | América-MG x Cruzeiro | Sim. `i != j`. (jogo 6) |
| 2 | 2 | América-MG x América-MG | Não. `i == j`. |

Resultado do teste de mesa: 9 combinações examinadas, 6 jogos exibidos. Confere com a execução (evidencias/tres_times_saida.txt).

### Resultados obtidos nos programas

| Quantidade de times | Jogos de ida e volta | Jogos em turno único |
|---|---|---|
| 3 | 6 | 3 |
| 4 | 12 | 6 |
| 5 | 20 | 10 |

Os valores de 4 e 5 times vêm das execuções do repositório (java_saida.txt, csharp_saida.txt, rust_saida.txt); os de 3 times vêm de tres_times_saida.txt.

### Questão 1 — Por que as combinações examinadas podem ser mais que os jogos exibidos?

Os laços examinam todos os pares (i, j), ou seja, n × n combinações, mas o `if` descarta algumas. No ida e volta, descarta as n combinações em que `i == j` (9 examinadas e 6 exibidas com 3 times). No turno único, descarta também os pares com `i > j`, ficando só com `i < j`.

### Questão 2 — O que acontece com a quantidade de confrontos ao acrescentar um time?

Cresce mais do que o time acrescentado: o novo time joga contra todos os anteriores. No ida e volta o total é n × (n − 1): 6, 12, 20. No turno único é n × (n − 1) / 2: 3, 6, 10. O acréscimo é maior a cada time novo (de 3 para 4 times, +6; de 4 para 5, +8 no ida e volta).

### Questão 3 — As três linguagens produziram os mesmos jogos e totais?

Sim. As saídas de Java, C# e Rust para 4 e 5 times foram comparadas linha a linha (ignorando o cabeçalho) e são idênticas, e as de 3 times também. Os totais conferem com a fórmula. Não houve divergência a corrigir.

## 7. Organização e participação

### Evidências de execução

Ver a Parte 3 e a pasta [evidencias/](evidencias/).

### Erros encontrados e como foram corrigidos

1. **Java — chaves faltando:** o código não compilava por falta de chaves em um bloco. Foram incluídas as chaves que fechavam os laços e a classe. (O aluno deve confirmar a mensagem exata do erro, se quiser incluí-la.)
2. **Java — arquivo não salvo:** o programa executado não refletia a alteração feita, porque o arquivo não tinha sido salvo antes de compilar. A correção foi salvar o arquivo e compilar de novo.
3. **C# — `TotalJogos` com maiúscula:** C# diferencia maiúsculas de minúsculas. A variável declarada era `totalJogos` e foi usada como `TotalJogos`, o que não compila. A correção foi usar o mesmo nome nas duas ocorrências.
4. **Execução em PowerShell (Claude Code):** ao rodar o Java para gerar a evidência, o argumento `-Dfile.encoding=UTF-8` foi interpretado pelo PowerShell de forma errada e o Java não encontrou a classe. A correção foi colocar os argumentos entre aspas e refazer o arquivo `java_saida.txt`.

### Uso de IA

O aluno trabalhou sozinho e usou IA de forma intencional. As ferramentas foram o **Claude** (Anthropic), em conversa de tutoria, e o **Claude Code** (Anthropic), como assistente no repositório. A divisão foi:

| Parte | Quem fez |
|---|---|
| Parte 1 do relatório | Aluno, com orientação de tutoria do Claude |
| Versão Java dos RF-01 a RF-06 com 4 times | Aluno, com orientação de tutoria do Claude |
| Depuração dos erros de chaves faltando e arquivo não salvo (Java) e de `TotalJogos` com maiúscula (C#) | Aluno, com orientação de tutoria do Claude |
| Código completo de C# e Rust com 4 times | Fornecido pelo Claude, digitado pelo aluno |
| Parte 4 do código (Tombense), execuções, evidências, README e as Partes 2, 3, 4, 5, 6 e 7 do relatório | Feito pelo Claude Code, supervisionado pelo aluno |

O exemplo da senha com `do-while`, na Questão 2 da Parte 1, foi escrito pelo Claude a pedido do aluno. As demais respostas da Parte 1 são do aluno.

O uso de IA não substitui a responsabilidade de compreender, testar e explicar o código. O aluno deve ser capaz de explicar cada trecho na apresentação.

### Participação e entrega

O enunciado pede o trabalho em **duplas**; este foi feito por **um único aluno**. A entrega individual precisa de confirmação do professor. O prazo informado no enunciado (01/11/2026) já passou. Não há segundo integrante: nenhum nome ou RA foi acrescentado.

### Parágrafo individual — contribuição e aprendizado

> **RASCUNHO — REVISAR PELO ALUNO** (reescrever com as próprias palavras e manter só o que for verdadeiro)
>
> Fiz este trabalho sozinho. Respondi a Parte 1 sobre a aula gravada e escrevi a versão Java dos requisitos RF-01 a RF-06 com os 4 times, com orientação do Claude. Corrigi erros que apareceram: chaves faltando e um arquivo que eu não tinha salvo em Java, e o nome `TotalJogos` com maiúscula em C#. Os códigos completos de C# e Rust foram fornecidos pelo Claude e eu os digitei. A Parte 4, as execuções, as evidências e a redação das demais partes do relatório foram feitas pelo Claude Code, e eu supervisionei. Meu principal aprendizado: um array tem tamanho fixo e por isso o Java exigiu copiar para um array maior, enquanto `List<string>` e `Vec<String>` crescem com `Add` e `push`; e dois laços aninhados com `i != j` ou `i < j` resolvem as duas tabelas. [Acrescentar aqui o que de fato aprendi e o que ainda tenho dúvida.]

### Referências

- Aula gravada do professor: https://youtu.be/JzwH1EVyO1Q
- Enunciado do professor Alexandre de Oliveira (Trabalhoavaliativolistas_20261025110456.pdf).
- BHARGAVA, Aditya. *Entendendo Algoritmos: um guia ilustrado para programadores e outros curiosos*. Capítulo 2. (Edição e páginas: PREENCHER PELO ALUNO.)
- Documentação Microsoft — `List<T>`: https://learn.microsoft.com/dotnet/api/system.collections.generic.list-1
- Documentação Microsoft — `LinkedList<T>`: https://learn.microsoft.com/dotnet/api/system.collections.generic.linkedlist-1
- Documentação Rust — `Vec`: https://doc.rust-lang.org/std/vec/struct.Vec.html
- Claude e Claude Code (Anthropic), conforme descrito em "Uso de IA".
