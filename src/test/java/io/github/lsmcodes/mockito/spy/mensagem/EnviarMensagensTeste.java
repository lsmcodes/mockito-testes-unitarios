package io.github.lsmcodes.mockito.spy.mensagem;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagensTeste {
        
        @Spy
        private EnviarMensagens enviarMensagens;

        @AfterEach
        void limparMensagens() {
                this.enviarMensagens.getMensagens().clear();
        }

        @Test
        void enviarMensagens_DeveSeComportarCorretamente_DeAcordoComAsInteracoes() {
                // Arrange
                Mensagem mensagem = new Mensagem("Hello, world!");

                // Assert
                Mockito.verifyNoInteractions(enviarMensagens);

                // Act
                enviarMensagens.adicionarMensagem(mensagem);

                // Assert
                Mockito.verify(enviarMensagens).adicionarMensagem(mensagem);
        }

        @Test
        void enviarMensagens_DeveConterMensagens_AposAdicionarMensagemSerInvocado() {
                // Arrange
                Mensagem mensagem = new Mensagem("Nova mensagem");

                // Act
                enviarMensagens.adicionarMensagem(mensagem);

                // Assert
                assertFalse(enviarMensagens.getMensagens().isEmpty());
        }

}