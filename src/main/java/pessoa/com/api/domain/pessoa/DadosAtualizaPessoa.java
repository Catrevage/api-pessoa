package pessoa.com.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pessoa.com.api.domain.endereco.DadosEndereco;

import java.time.LocalDate;

public record DadosAtualizaPessoa(

        @NotNull
        Long id,

        String nome,


        LocalDate dataNascimento
) {
}
