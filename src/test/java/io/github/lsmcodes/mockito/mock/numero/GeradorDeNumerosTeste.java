package io.github.lsmcodes.mockito.mock.numero;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GeradorDeNumerosTeste {

        private MockedStatic<GeradorDeNumeros> geradorDeNumeros;

        @BeforeEach
        void instanciarGeradorDeNumeros()  {
                this.geradorDeNumeros = Mockito.mockStatic(GeradorDeNumeros.class);
        }

        @AfterEach
        void closeGeradorDeNumeros() {
                this.geradorDeNumeros.close();
        }

        @Test
        void gerarNumerosAleatorios_DeveGerarListaDeNumerosAleatorios_ComOTamanhoEspecificado() {
                // Arrange
                List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
                this.geradorDeNumeros.when(() -> GeradorDeNumeros.gerarNumerosAleatorios(ArgumentMatchers.anyInt())).thenReturn(integers);

                // Assert
                assertEquals(integers, GeradorDeNumeros.gerarNumerosAleatorios(5));
        }

        @Test
        void gerarNumerosAleatorios_DeveGerarListaDeNumerosAleatorios_SemTamanhoEspecificado() {
                // Arrange
                List<Integer> integers = List.of(1, 4, 6, 8);
                this.geradorDeNumeros.when(GeradorDeNumeros::gerarNumerosAleatorios).thenReturn(integers);

                // Assert
                assertEquals(integers, GeradorDeNumeros.gerarNumerosAleatorios());

        }

}