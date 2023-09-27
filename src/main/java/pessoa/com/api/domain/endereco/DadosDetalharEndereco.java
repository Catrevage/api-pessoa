package pessoa.com.api.domain.endereco;

public record DadosDetalharEndereco(Long id, String logradouro, String cep, String numero,
                                    String cidade, Long idPessoa, boolean principal) {

    public DadosDetalharEndereco(Endereco dados){
        this(dados.getId(),dados.getLogradouro(), dados.getCep(),
                dados.getNumero(), dados.getCidade(), dados.getPessoa().getId(), dados.isPrincipal());
    }

}
