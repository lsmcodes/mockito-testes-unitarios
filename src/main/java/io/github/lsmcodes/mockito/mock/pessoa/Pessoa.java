package io.github.lsmcodes.mockito.mock.pessoa;

import java.time.LocalDate;

public class Pessoa {

        private String nome;
        private String documento;
        private LocalDate nascimento;
        private Localizacao localizacao;

        public Pessoa(final String nome, final String documento, final LocalDate nascimento) {
                this.nome = nome;
                this.documento = documento;
                this.nascimento = nascimento;
        }

        public String getNome() {
                return nome;
        }

        public String getDocumento() {
                return documento;
        }

        public LocalDate getNascimento() {
                return nascimento;
        }

        public Localizacao getLocalizacao() {
                return localizacao;
        }

        public void setLocalizacao(Localizacao localizacao) {
                this.localizacao = localizacao;
        }

        @Override
        public String toString() {
                return "Nome: \"" + getNome() + "\", documento: \"" + getDocumento() + "\", nascimento: \""
                                + getNascimento() + "\", localizacao: " + getLocalizacao();
        }

}