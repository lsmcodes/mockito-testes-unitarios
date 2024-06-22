package io.github.lsmcodes.mockito.captor;

import java.util.Scanner;

public class EnviarEmail {

        private PlataformaDeEmail plataformaDeEmail;

        public EnviarEmail(PlataformaDeEmail plataformaDeEmail) {
                this.plataformaDeEmail = plataformaDeEmail;
        }

        public Email enviarEmail(String enderecoDeEmail, String mensagem, boolean formatoHTML) {
                Email email = null;

                if(formatoHTML) {
                        email = new Email(enderecoDeEmail, mensagem, Formato.HTML);
                } else {
                        email = new Email(enderecoDeEmail, mensagem, Formato.TEXTO);
                }

                plataformaDeEmail.enviarEmail(email);
                return email;
        }

        public static void main(String[] args) {
                PlataformaDeEmail plataformaDeEmail = new PlataformaDeEmail();
                EnviarEmail enviarEmail = new EnviarEmail(plataformaDeEmail);

                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;
                String opcao;

                while (aguardarInput) {
                        System.out.println("\nMenu:\n"
                                + "1 - Enviar email\n"
                                + "Para sair, apenas digite qualquer outro numero");

                        opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Endereço de email:");
                                        String enderecoDeEmail = scanner.nextLine();

                                        System.out.println("Mensagem:");
                                        String mensagem = scanner.nextLine();

                                        System.out.println("Formato da mensagem:\n" +
                                                "1 - HTML\n" +
                                                "2 - TEXTO");

                                        int opcaoDeFormato = Integer.parseInt(scanner.nextLine());
                                        boolean formatoHTML = opcaoDeFormato==1?true:false;

                                        Email emailEnviado = enviarEmail.enviarEmail(enderecoDeEmail, mensagem, formatoHTML);

                                        System.out.println("Email enviado. Detalhes: " + emailEnviado);
                                        break;
                                default:
                                        aguardarInput = false;
                                        break;
                        }
                }
                scanner.close();
        }

}