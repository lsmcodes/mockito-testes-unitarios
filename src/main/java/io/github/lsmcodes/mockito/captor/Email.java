package io.github.lsmcodes.mockito.captor;

public class Email {

        private String enderecoDeEmail;
        private String mensagem;
        private Formato formato;

        public Email(String enderecoDeEmail, String mensagem, Formato formato) {
                this.enderecoDeEmail = enderecoDeEmail;
                this.mensagem = mensagem;
                this.formato = formato;
        }

        public String getEnderecoDeEmail() {
                return enderecoDeEmail;
        }

        public String getMensagem() {
                return mensagem;
        }

        public Formato getFormato() {
                return formato;
        }

        @Override
        public String toString() {
                return "Endereço de email: \"" + getEnderecoDeEmail() + "\", mensagem: \"" + getMensagem() + "\", formato: \""
                        + getFormato() + "\"";
        }

}