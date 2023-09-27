package pessoa.com.api.domain.endereco;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoa.com.api.domain.pessoa.Pessoa;

@Entity(name = "Endereco")
@Table(name = "endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    private boolean principal;



    public Endereco(DadosCadastroEndereco dados, Pessoa pessoa) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.pessoa = pessoa;
    }


    public void atualizarInformacoes(DadosAtualizaEndereco dados) {
        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }

        if(dados.numero() != null){
            this.numero = dados.numero();
        }

        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
    }
}
