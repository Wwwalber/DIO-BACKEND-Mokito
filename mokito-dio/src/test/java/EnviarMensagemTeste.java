import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import mokito.example.two.EnviarMensagem;
import mokito.example.two.Mensagem;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy
    private  EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoDaClassse(){
        Mockito.verifyNoInteractions(enviarMensagem);

        Mensagem mensagem = new Mensagem("Oi Walber!");
        enviarMensagem.adicionarMensagem(mensagem);

        Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);

        Assertions.assertTrue(enviarMensagem.getMensagens().isEmpty());
    }
}
