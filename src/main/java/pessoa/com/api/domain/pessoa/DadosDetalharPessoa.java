package pessoa.com.api.domain.pessoa;

import pessoa.com.api.domain.endereco.Endereco;

import java.time.LocalDate;

public record DadosDetalharPessoa(Long id, String nome, LocalDate data) {
    public DadosDetalharPessoa(Pessoa pessoa){
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getDataNascimento()
        );
    }
}
