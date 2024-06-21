package io.github.lsmcodes.mockito.spy.conta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {

        @Spy
        private Conta conta = new Conta(1000);

        @Test
        void conta_DeveTerOsMetodosExecutadosNaOrdemCorreta_QuandoPagarBoletoForInvocado() {
                // Arrange
                InOrder inOrder = Mockito.inOrder(conta);

                // Act
                conta.pagarBoleto(300);

                // Assert
                inOrder.verify(conta).pagarBoleto(300);
                inOrder.verify(conta).validarSaldo(300);
                inOrder.verify(conta).debitar(300);
                inOrder.verify(conta).enviarCreditoParaEmissor(300);
        }

        @Test
        void validarSaldo_DeveSerExecutado_QuantasVezesForInvocado() {
                // Arrange
                int vezesInvocado = 3;

                // Act
                conta.validarSaldo(405);
                conta.validarSaldo(210);
                conta.validarSaldo(320);

                // Assert
                Mockito.verify(conta, Mockito.times(vezesInvocado)).validarSaldo(ArgumentMatchers.anyDouble());
        }

}