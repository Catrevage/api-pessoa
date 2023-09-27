package pessoa.com.api.domain.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaEndereco(
        @NotNull
        Long id,
        String logradouro,

        String cep,

        String numero,

        String cidade,

        Long idPessoa,

        boolean principal
) {
}
