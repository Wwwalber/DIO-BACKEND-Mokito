import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import mokito.example.three.Conta;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {

    @Spy
    // private Conta conta; ou
    private Conta conta = new Conta(1000);

    @Test
    void validaOrdemDeChamada(){

        conta.pagaBoleto(300); // vou inserir dados e testa-los mas na frente

        InOrder inOrder = Mockito.inOrder(conta);

        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        //inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);
        inOrder.verify(conta).debita(300);
    }

    @Test
    void validarQuantidadeDeChamadas(){
        conta.validaSaldo(300);
        conta.validaSaldo(300);
        conta.validaSaldo(300);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(300);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());

    }

    @Test
    void retornaTrueParaQualquerValorNaValidacaoDeSaldo(){
        Mockito.doNothing().when(conta).validaSaldo(ArgumentMatchers.anyInt());
        // aqui não vai fazer nada mesmo desconsiderando a validação lá do método
        conta.validaSaldo(3_500);
    }

}
