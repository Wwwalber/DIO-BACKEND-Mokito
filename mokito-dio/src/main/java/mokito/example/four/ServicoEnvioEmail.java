package mokito.example.four;

public class ServicoEnvioEmail {

    private PlataFormaDeEnvio plataforma;

    public void enviaEmail(String enderecoEmail, String mensagem, boolean formatoHtml) {

        Email email = null;

        if(formatoHtml) {
            email = new Email(enderecoEmail, Formato.HTML, mensagem);
        }else{
            email = new Email(enderecoEmail, Formato.TEXTO, mensagem);
        }

        plataforma.enviaEmail(email);
    }
}
