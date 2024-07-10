import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mokito.example.four.Email;
import mokito.example.four.Formato;
import mokito.example.four.PlataFormaDeEnvio;
import mokito.example.four.ServicoEnvioEmail;

@ExtendWith(MockitoExtension.class)
public class ServicoDeEmailTeste {

    @Mock
    private PlataFormaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servicoEnvioEmail;

    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Test
    void validarDadosEnviadosParaAPlataforma(){
        String enderecoDeEmail = "usuarios@plataform.com";
        String mensagem = "Olá, este é um teste de envio de email.";
        boolean formatoHtml = false;

        servicoEnvioEmail.enviaEmail(enderecoDeEmail, mensagem, formatoHtml);

        Mockito.verify(plataforma).enviaEmail(emailCaptor.capture());

        Email emailCapturado = emailCaptor.getValue();

        Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(formatoHtml, emailCapturado.getFormato() == Formato.TEXTO);
    }
}
