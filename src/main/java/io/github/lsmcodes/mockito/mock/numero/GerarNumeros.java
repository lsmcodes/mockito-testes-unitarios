package io.github.lsmcodes.mockito.mock.numero;

import java.util.List;
import java.util.Scanner;

public class GerarNumeros {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;
                String opcao;

                while (aguardarInput) {
                        System.out.println("\nMenu:\n"
                                + "1 - Gerar lista de numeros aleatorios de tamanho definido\n"
                                + "2 - Gerar lista de numeros aleatorios de tamanho entre 1 e 10\n"
                                + "Para sair, apenas digite qualquer outro numero");

                        opcao = scanner.nextLine();

                        List<Integer> listaDeNumerosGerados;

                        switch (opcao) {
                                case "1":
                                        System.out.println("Tamanho:");
                                        int tamanho = Integer.parseInt(scanner.nextLine());
                                        listaDeNumerosGerados = GeradorDeNumeros.gerarNumerosAleatorios(tamanho);
                                        System.out.println("Numeros" + listaDeNumerosGerados);
                                        break;
                                case "2":
                                        listaDeNumerosGerados = GeradorDeNumeros.gerarNumerosAleatorios();
                                        System.out.println("Numeros" + listaDeNumerosGerados);
                                        break;
                                default:
                                        aguardarInput = false;
                                        break;
                        }
                }
                scanner.close();
        }

}