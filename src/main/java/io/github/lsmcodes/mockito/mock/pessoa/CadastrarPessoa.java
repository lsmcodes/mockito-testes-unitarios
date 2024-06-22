package io.github.lsmcodes.mockito.mock.pessoa;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Classe que simula o cadastro de pessoas
 */
public class CadastrarPessoa {

        private CorreiosAPI correiosAPI;

        public CadastrarPessoa(final CorreiosAPI correiosAPI) {
                this.correiosAPI = correiosAPI;
        }

        public CorreiosAPI getCorreiosAPI() {
                return correiosAPI;
        }

        public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
                Pessoa pessoa = new Pessoa(nome, documento, nascimento);
                Localizacao localizacao = this.correiosAPI.encontrarLocalizacaoPeloCEP(cep);
                pessoa.setLocalizacao(localizacao);
                return pessoa;
        }

        public static void main(String[] args) {
                CorreiosAPI correiosAPI = new CorreiosAPI();
                CadastrarPessoa cadastrarPessoa = new CadastrarPessoa(correiosAPI);

                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;
                String opcao;

                while (aguardarInput) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Cadastrar pessoa\n"
                                        + "Para sair, apenas digite qualquer outro numero");

                        opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Documento (RG):");
                                        String documento = scanner.nextLine();

                                        System.out.println("Data de Nascimento (ano-mes-dia):");
                                        String[] nascimento = scanner.nextLine().split("-");
                                        int ano = Integer.parseInt(nascimento[0]);
                                        int mes = Integer.parseInt(nascimento[1]);
                                        int dia = Integer.parseInt(nascimento[2]);

                                        System.out.println("CEP:");
                                        String cep = scanner.nextLine();

                                        Pessoa pessoaCadastrada = cadastrarPessoa.cadastrarPessoa(nome, documento, LocalDate.of(ano, mes, dia), cep);
                                        System.out.println("Cadastro completo. Detalhes: " + pessoaCadastrada.toString());
                                        break;
                                default:
                                        aguardarInput = false;
                                        break;
                        }
                }
                scanner.close();
        }

}