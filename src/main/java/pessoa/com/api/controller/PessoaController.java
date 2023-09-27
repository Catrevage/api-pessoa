package pessoa.com.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pessoa.com.api.domain.pessoa.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        var uri = uriBuilder.path("pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        repository.save(pessoa);
        return ResponseEntity.created(uri).body(new DadosDetalharPessoa(pessoa));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalharPessoa(pessoa));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalharPessoa> detalhar(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        var lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
}
