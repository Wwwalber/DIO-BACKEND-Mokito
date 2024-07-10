import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mokito.example.ApiDosCorreios;
import mokito.example.CadastrarPessoa;
import mokito.example.DadosLocalizacao;
import mokito.example.Pessoa;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;
    
    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        // dados para serem chamados em vez de ir láaaa na classe. Isso serve como uma simulação
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");
        
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);
        Pessoa jose = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");

        assertEquals("José", jose.getNome());
        assertEquals("28578527976", jose.getDocumento());
        assertEquals("Uberaba", jose.getEndereco().getCidade());
        assertEquals("Rua Castro Alves", jose.getEndereco().getLogradouro());
        
    }

    
    @Test
    void lancarExceptionQuandoChamarAPIDosCorreios(){
        // testar se ocoorrer uma exceção
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);
        
        // ser esperava a excessão então ok agora, fomos avisados
        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300"));
    }

}
