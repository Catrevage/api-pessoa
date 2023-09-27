package pessoa.com.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String cep,
        @NotBlank
        String numero,

        @NotBlank
        String cidade) {
}
