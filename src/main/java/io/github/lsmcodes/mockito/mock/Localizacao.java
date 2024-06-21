package io.github.lsmcodes.mockito.mock;

public class Localizacao {

        private String uf;
        private String cidade;
        private String logradouro;
        private String complemento;
        private String bairro;

        public Localizacao(String uf, String cidade, String logradouro, String complemento, String bairro) {
                this.uf = uf;
                this.cidade = cidade;
                this.logradouro = logradouro;
                this.complemento = complemento;
                this.bairro = bairro;
        }

        public String getUf() {
                return uf;
        }

        public String getCidade() {
                return cidade;
        }

        public String getLogradouro() {
                return logradouro;
        }

        public String getComplemento() {
                return complemento;
        }

        public String getBairro() {
                return bairro;
        }

}