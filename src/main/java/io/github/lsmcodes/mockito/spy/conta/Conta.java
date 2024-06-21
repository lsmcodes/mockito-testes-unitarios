package io.github.lsmcodes.mockito.spy.conta;

import io.github.lsmcodes.mockito.spy.mensagem.EnviarMensagens;
import io.github.lsmcodes.mockito.spy.mensagem.Mensagem;

import java.util.List;
import java.util.Scanner;

/**
 * Classe que simula uma conta bancaria
 */
public class Conta {

        private double saldo;

        public Conta(double saldo) {
                this.saldo = saldo;
        }

        public double getSaldo() {
                return saldo;
        }

        public void pagarBoleto(double valorAPagar) {
                validarSaldo(valorAPagar);
                debitar(valorAPagar);
                enviarCreditoParaEmissor(valorAPagar);
        }

        public void validarSaldo(double valorAPagar) {
                if(valorAPagar > this.saldo) {
                        throw new IllegalStateException("Saldo insuficiente.");
                }
        }

        public void debitar(double valorAPagar) {
                this.saldo -= valorAPagar;
        }

        public void enviarCreditoParaEmissor(double valorPago) {
                // Envia valor para emissor do boleto
        }

        public static void main(String[] args) {
                Conta conta = null;

                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;
                String opcao;

                while (aguardarInput) {
                        System.out.println("\nMenu:\n"
                                + "1 - Criar conta\n"
                                + "2 - Pagar boleto\n"
                                + "Para sair, apenas digite qualquer outro numero");

                        opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Saldo da conta:");
                                        double saldo = Double.parseDouble(scanner.nextLine());
                                        conta = new Conta(saldo);
                                        break;
                                case "2":
                                        if(conta == null) {
                                                throw new IllegalStateException("Você não possui uma conta.");
                                        }

                                        System.out.println("Valor do boleto:");
                                        double valorAPagar = Double.parseDouble(scanner.nextLine());
                                        conta.pagarBoleto(valorAPagar);

                                        System.out.println("Boleto pago. Saldo atual da conta: R$" + conta.getSaldo() + ".");
                                        break;
                                default:
                                        aguardarInput = false;
                                        break;
                        }
                }
                scanner.close();
        }

}