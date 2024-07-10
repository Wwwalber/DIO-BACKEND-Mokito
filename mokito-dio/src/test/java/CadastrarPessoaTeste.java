import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mokito.example.ApiDosCorreios;

public class CadastrarPessoaTeste {
    @SuppressWarnings("deprecation")
    @BeforeAll
    void setup(){
        MockitoAnnotations.initMocks(this);  // Inicializa mocks de dependências
    }

    private ApiDosCorreios apiDosCorreios = Mockito.mock(ApiDosCorreios.class);
}