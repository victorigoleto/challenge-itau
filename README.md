# Challenge-itau
Projeto desenvolvido para o processo seletivo do Banco Itaú, em que consiste em validar uma senha de acordo com algumas definições

## 📝Descrição
Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

## ❔Problema

Construa uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).  
Output: Um boolean indicando se a senha é válida.

Embora nossas aplicações sejam escritas em Kotlin e C# (.net core), você não precisa escrever sua solução usando elas. Use a linguagem de programação que considera ter mais 

## 🎯Solução
Meu plano A de ínicio era montar uma aplicação web com a presença de 2 camadas: front-end e back-end, mas como se tratava de um case de apenas de validação tomei a decisão de focar apenas no back-end. Então fui para o plano B, pesquisar formas de realizar essa valiadação e achei muitas formas mas a que eu implementei foi a mais valida e prática: <b>regex</b>. Outro ponto importante é que o metodo de requisição POST foi utilizado ao invés do GET, pois uma senha geralmente não se consulta e sim cadastra respeitando questões de segurança.

## 🚀Tecnologias Utilizadas
<p>• Java 11</p>
<p>• Spring Boot</p>
<p>• JPA / Hibernate</p>
<p>• Lombok</p>
<p>• Maven</p>
<p>• Banco de Dados H2</p>
<p>• Postman</p>

## 💻 Pré-requisitos para executar o projeto localmente
Antes de começar, verifique se você atendeu aos seguintes requisitos:
<!---Estes são apenas requisitos de exemplo. Adicionar, duplicar ou remover conforme necessário--->
* Você instalou a versão mais recente de `<JDK Java 11 / IDE Eclipse ou Netbeans / Git e GitHub / Postman>`
* Você tem uma máquina `<Windows / Mac / Linux>`.

## ☕ Usando a API
```
Para usar a API, clone o projeto em qualquer lugar da sua máquina:
```
<img src="https://i.imgur.com/2g5ZNJa.png">

<br><br>

```
Agora abra sua IDE de escolha e importe o projeto. Abra o terminal e rode o seguinte comando para validar e compilar o projeto: mvn clean install
```
<img src="https://i.imgur.com/VfgMK6M.png">

<br><br>


```
Feito isso, rode a aplicação main ApiValidacaoDeSenhasApplication, que subira uma Api Web no contexto Spring e banco de dados de memória H2
```
<img src="https://i.imgur.com/ZuAlzuh.png">

<br><br>


```
Com a aplicação iniciada, iremos fazer a requisição de validação através do Postman em que o input consiste em digitar uma senha seguindo os padrões definidos podendo o output retornar true ou false.
```
<img src="https://i.imgur.com/tJ4K80j.png">
