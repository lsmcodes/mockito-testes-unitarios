package io.github.lsmcodes.mockito.mock.numero;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class GeradorDeNumeros {

        private static SplittableRandom random = new SplittableRandom();

        private GeradorDeNumeros() {}

        public static List<Integer> gerarNumerosAleatorios(int tamanhoDaLista) {
                return random.ints().boxed().limit(tamanhoDaLista).collect(Collectors.toList());
        }

        public static List<Integer> gerarNumerosAleatorios() {
                return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
        }

}