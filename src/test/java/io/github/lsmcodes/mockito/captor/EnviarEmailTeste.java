package io.github.lsmcodes.mockito.captor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarEmailTeste {

        @Mock
        private PlataformaDeEmail plataformaDeEmail;

        @InjectMocks
        private EnviarEmail enviarEmail;

        @Captor
        private ArgumentCaptor<Email> captor;

        @Test
        void enviarEmail_DeveReceberAsInformacoesDeEmailCorretamente_QuandoForInvocado() {
                // Arrange
                String enderecoDeEmail = "exemplo@gmail.com";
                String mensagem = "Hello, World!";
                boolean formatoHTML = false;

                // Act
                enviarEmail.enviarEmail(enderecoDeEmail, mensagem, formatoHTML);

                // Assert
                Mockito.verify(plataformaDeEmail).enviarEmail(captor.capture());
                Email emailCapturado = captor.getValue();
                assertEquals(enderecoDeEmail, emailCapturado.getEnderecoDeEmail());
                assertEquals(mensagem, emailCapturado.getMensagem());
                assertEquals(Formato.TEXTO, emailCapturado.getFormato());
        }

}