package io.github.lsmcodes.mockito.spy.mensagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que simula uma plataforma de mensagens
 */
public class EnviarMensagens {

        private List<Mensagem> mensagens = new ArrayList<>();

        public void adicionarMensagem(Mensagem mensagem) {
                this.mensagens.add(mensagem);
        }

        public List<Mensagem> getMensagens() {
                return this.mensagens;
        }

        public static void main(String[] args) {
                EnviarMensagens enviarMensagens = new EnviarMensagens();

                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;
                String opcao;

                while (aguardarInput) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar mensagem\n"
                                        + "2 - Listar mensagens\n"
                                        + "Para sair, apenas digite qualquer outro numero");

                        opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Mensagem:");
                                        String mensagem = scanner.nextLine();
                                        enviarMensagens.adicionarMensagem(new Mensagem(mensagem));
                                        break;
                                case "2":
                                        List<Mensagem> mensagens = enviarMensagens.getMensagens();
                                        mensagens.stream().forEach(System.out::println);
                                        break;
                                default:
                                        aguardarInput = false;
                                        break;
                        }
                }
                scanner.close();
        }
}