package pessoa.com.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pessoa.com.api.domain.endereco.*;
import pessoa.com.api.domain.pessoa.PessoaRepository;


import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        var pessoa = pessoaRepository.getReferenceById(dados.idPessoa());
        var endereco = new Endereco(dados, pessoa);
        var uri = uriBuilder.path("endereco/{id}").buildAndExpand(endereco.getId()).toUri();

        repository.save(endereco);
        return ResponseEntity.created(uri).body(new DadosDetalharEndereco(endereco));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaEndereco dados) {

        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalharEndereco(endereco));

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var endereco = repository.findByPessoaId(id).stream().map(DadosDetalharEndereco::new);
        return ResponseEntity.ok(endereco);
    }


}
