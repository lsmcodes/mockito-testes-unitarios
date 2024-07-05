# DIO - Trilha Testes e Gerenciamento de Dependências Java
<div style="display:inline-block">
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Java-black?style=for-the-badge&logo=OpenJDK&logoColor=white">
                <img src="https://img.shields.io/badge/Java-white?style=for-the-badge&logo=OpenJDK&logoColor=black" />
        </picture>
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Maven-black?style=for-the-badge&logo=ApacheMaven&logoColor=white">
                <img src="https://img.shields.io/badge/Maven-white?style=for-the-badge&logo=ApacheMaven&logoColor=black" />
        </picture>
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Spring_Boot-black?style=for-the-badge&logo=SpringBoot&logoColor=white">
                <img src="https://img.shields.io/badge/Spring_Boot-white?style=for-the-badge&logo=SpringBoot&logoColor=black" />
        </picture>
        <picture>
                <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/JUnit5-black?style=for-the-badge&logo=JUnit5&logoColor=white">
                <img src="https://img.shields.io/badge/JUnit5-white?style=for-the-badge&logo=JUnit5&logoColor=black" />
        </picture>
</div>

## Autor dos Exercícios e Repositório Original
- [Willyan Guimarães Caetano](https://github.com/willyancaetano)
- [Mockito Exemplos](https://github.com/willyancaetano/mockito-exemplos)

## Mockito
`Mockito` é o framework mais popular para testes com `mocks` e `spies` em aplicações Java.

## Exercícios
Este repositório contém exercícios que exemplificas a utilização do Mockito e que cobrem os seguintes temas:
- Mocks
- Spies
- Capturando argumentos com Captor
- Manipulando retornos com stubs
- Mock de métodos estáticos

## Configurar Mockito
Para utilizar o Mockito, adicione as dependências Mockito Core e Mockito JUnit Jupiter ao arquivo `pom.xml` ou ao `build.gradle` do seu projeto. A primeira consiste na API principal que inclui todas as funcionalidades do Mockito, a segunda dá suporte ao JUnit.
### Maven
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>

```

### Gradle
```groovy
testImplementation group: 'org.mockito', name: 'mockito-core', version: '5.12.0'

testImplementation group: 'org.mockito', name: 'mockito-junit-jupiter', version: '5.12.0'
```

## Mocks
`Mocks` são objetos que simulam o real comportamento de dependências, a fim de testar se essas dependências serão corretamente utilizadas. No Mockito, os mocks permitem que `stubs` de chamadas de métodos sejam feitos, o que significa que é possível definir exatamente o que os métodos devem retornar ou fazer.

Exemplo que simula o cadastro de uma pessoa e verifica se a pessoa foi cadastrada com os dados corretos:
```java
@Mock
private CorreiosAPI correiosAPI;

@InjectMocks
private CadastrarPessoa cadastrarPessoa;

@Test
void cadastrarPessoa_DeveCadastrarPessoaCorretamente_QuandoReceberDadosDeCadastro() {
        // Arrange (Arranjar)
        Localizacao localizacao = new Localizacao("BA", "Salvador", "Rua 10 de Junho", "Rua", "Bonfim");
        Mockito.when(this.correiosAPI.encontrarLocalizacaoPeloCEP("40415-185")).thenReturn(localizacao);

        Pessoa pessoa = new Pessoa("Carla", "34.795.744-4", LocalDate.of(1999, 07, 21));
        pessoa.setLocalizacao(localizacao);

        // Act (Agir)
        Pessoa pessoaCadastrada = this.cadastrarPessoa.cadastrarPessoa("Carla", "34.795.744-4",
                        LocalDate.of(1999, 07, 21), "40415-185");

        // Assert (Afirmar)
        assertAll(() -> assertEquals(pessoa.getNome(), pessoaCadastrada.getNome()),
                        () -> assertEquals(pessoa.getDocumento(), pessoaCadastrada.getDocumento()),
                        () -> assertEquals(pessoa.getNascimento(), pessoaCadastrada.getNascimento()),
                        () -> assertEquals(pessoa.getLocalizacao(), pessoaCadastrada.getLocalizacao()));
}
```

## Spies
`Spies` são objetos que provêm uma forma de "espiar" o objeto real. Com um spy, é possível invocar todos os métodos reais do objeto enquanto cada interação com eles é monitorada. No Mockito, os spies são parcialmente mocks, já que com eles é possível fazer o stub de alguns métodos do objeto real, enquanto invocações reais de outros métodos do mesmo objeto também podem ser feitas.

Exemplo que interage com o método adicionarMensagem e verifica se houve uma interação:
```java
@Spy
private EnviarMensagens enviarMensagens;
    
@Test
void enviarMensagens_DeveSeComportarCorretamente_DeAcordoComAsInteracoes() {
        // Arrange (Arranjar)
        Mensagem mensagem = new Mensagem("Hello, world!");
    
        // Act (Agir)
        enviarMensagens.adicionarMensagem(mensagem);
    
        // Assert (Afirmar)
        Mockito.verify(enviarMensagens).adicionarMensagem(mensagem);
}
```

## Anotações
A seguir estão as anotações utilizadas nos exercícios e suas respectivas descrições.

| Anotação       | Descrição                                                                        |
|----------------|----------------------------------------------------------------------------------|
| `@Test`        | Denota que o método anotado é um método de teste                                 |
| `@Mock`        | Marca um campo como sendo um objeto mock                                         |
| `@InjectMocks` | Marca um campo onde deve a injeção de um mock deve ser performada                |
| `@Spy`         | Permite o encapsulamento de uma instância de campo em um objeto spy              |
| `@Captor`      | Permite a criação de um ArgumentCaptor (classe que captura argumentos) em campos |


## Referências
- Mockito Mock vs Spy in Spring Boot Tests - https://springframework.guru/mockito-mock-vs-spy-in-spring-boot-tests/
- Mock - https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mock.html
- InjectMocks - https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/InjectMocks.html
- Spy - https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Spy.html
- Captor - https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Captor.html

## Recursos
Geradores utilizados para gerar os dados:
- Gerador de CEP - https://www.4devs.com.br/gerador_de_cep
- Gerador de RG - https://www.4devs.com.br/gerador_de_rg