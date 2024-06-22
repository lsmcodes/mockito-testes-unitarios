package io.github.lsmcodes.mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

        @Mock
        private CorreiosAPI correiosAPI;

        @InjectMocks
        private CadastrarPessoa cadastrarPessoa;

        @Test
        void cadastrarPessoa_DeveCadastrarPessoaCorretamente_QuandoReceberDadosDeCadastro() {
                // Arrange
                Localizacao localizacao = new Localizacao("BA", "Salvador", "Rua 10 de Junho", "Rua", "Bonfim");
                Mockito.when(this.correiosAPI.encontrarLocalizacaoPeloCEP("40415-185")).thenReturn(localizacao);

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

        @Test
        void encontrarLocalizacaoPeloCEP_DeveLancarRuntimeException_QuandoReceberQualquerCEP() {
                // Arrange
                Mockito.when(this.correiosAPI.encontrarLocalizacaoPeloCEP(anyString())).thenThrow(RuntimeException.class);

                // Assert
                assertThrows(RuntimeException.class, () -> this.cadastrarPessoa.cadastrarPessoa("Lucas", "10.855.455-7",
                        LocalDate.of(2003, 02, 03), "29158-207"));
        }

}