package pessoa.com.api.domain.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


    List<Endereco> findByPessoaId(Long id);
}
