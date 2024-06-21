package io.github.lsmcodes.mockito.mock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

        @Mock
        private CorreiosAPI mockCorreiosAPI;

        @InjectMocks
        private CadastrarPessoa cadastrarPessoa;

        @Test
        void cadastrarPessoa_DeveCadastrarPessoaCorretamente_QuandoReceberDadosDeCadastro() {
                // Arrange
                Localizacao localizacao = new Localizacao("BA", "Salvador", "Rua 10 de Junho", "Rua", "Bonfim");
                Mockito.when(this.mockCorreiosAPI.encontrarLocalizacaoPeloCEP("40415-185")).thenReturn(localizacao);

                Pessoa pessoa = new Pessoa("Carla", "34.795.744-4", LocalDate.of(1999, 07, 21));
                pessoa.setLocalizacao(localizacao);

                // Act
                Pessoa pessoaCadastrada = this.cadastrarPessoa.cadastrarPessoa("Carla", "34.795.744-4",
                                LocalDate.of(1999, 07, 21), "40415-185");

                // Assert
                assertAll(() -> assertEquals(pessoa.getNome(), pessoaCadastrada.getNome()),
                                () -> assertEquals(pessoa.getDocumento(), pessoaCadastrada.getDocumento()),
                                () -> assertEquals(pessoa.getNascimento(), pessoaCadastrada.getNascimento()),
                                () -> assertEquals(pessoa.getLocalizacao(), pessoaCadastrada.getLocalizacao()));
        }

}