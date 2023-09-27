package pessoa.com.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pessoa.com.api.domain.endereco.DadosEndereco;
import pessoa.com.api.domain.endereco.Endereco;

import java.time.LocalDate;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,

        @NotNull
        LocalDate dataNascimento

      ) {
}
