package mokito.example.four;

public class Email {
    private String enderecoEmail;

    private String mensagem;

    private Formato formato;

    public Email(String enderecoEmail, Formato formato, String mensagem) {
        this.enderecoEmail = enderecoEmail;
        this.formato = formato;
        this.mensagem = mensagem;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Formato getFormato() {
        return formato;
    }

    

}
