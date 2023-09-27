package pessoa.com.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pessoa.com.api.domain.pessoa.Pessoa;

public record DadosCadastroEndereco(

        @NotNull
        String logradouro,

        @NotNull
        String cep,

        @NotNull
        String numero,

        @NotNull
        String cidade,

        @NotNull
        Long idPessoa,

        @NotNull
        boolean principal

) {
}
