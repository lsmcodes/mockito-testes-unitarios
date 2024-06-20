# DIO - Trilha Testes e Gerenciamento de Dependências Java
www.dio.me

## Repositório Original do Curso
- [Mockito Exemplos](https://github.com/willyancaetano/mockito-exemplos)

## Mockito
`Mockito` é o framework mais popular para testes com `mocks` em aplicações Java.

## O que são Mocks?
`Mocks` são objetos que simulam as dependências do código que está sendo testado. Isso permite testar funcionalidades de uma parte específica do código isoladamente e sem a preocupação com a configuração e os possíveis efeitos colaterais de dependências reais.

## Exercícios
Este repositório contém exercícios que exemplificas a utilização do Mockito e que cobrem os seguintes temas:
- Mock de objetos
- Espiar objetos
- Capturar argumentos
- Manipulando retornos
- Mock de métodos estáticos

## Configurar Mockito
Para utilizar o Mockito, adicione as dependências Mockito Core e Mockito JUnit Jupiter ao arquivo `pom.xml` ou ao `build.gradle` do seu projeto. A primeira consiste na API principal que inclui todas as funcionalidades do Mockito, a segunda dá suporte ao JUnit.
### Maven
```xml
<!-- Mockito Core -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>

<!-- Mockito JUnit Jupiter -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>

```

### Gradle
```groovy
// Mockito Core
testImplementation group: 'org.mockito', name: 'mockito-core', version: '5.12.0'

// Mockito JUnit Jupiter
testImplementation group: 'org.mockito', name: 'mockito-junit-jupiter', version: '5.12.0'
```