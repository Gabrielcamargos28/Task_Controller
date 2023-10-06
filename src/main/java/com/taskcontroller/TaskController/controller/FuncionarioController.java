package com.taskcontroller.TaskController.controller;

import com.taskcontroller.TaskController.domain.funcionario.*;
import com.taskcontroller.TaskController.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repository;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriBuilder){

        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        Funcionario funcionario = new Funcionario(dados.nome(),dados.login(),encryptedPassword,dados.role(),dados.telefone(), dados.cep(), dados.email(), dados.numero() );
        repository.save(funcionario);

        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping("/listarfuncionarios")
    public ResponseEntity<Page<DadosDetalhamentoFuncionario>> listarFuncionarios(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        var page = repository.findByAtivoTrue(paginacao).map(DadosDetalhamentoFuncionario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/atualizarfuncionario")
    @Transactional
    public ResponseEntity atualizarFuncionario(@RequestBody DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id_funcionario());
        funcionario.atualizarFuncionario(dados);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @DeleteMapping("/desativarfuncionario/{id_funcionario}")
    @Transactional
    public ResponseEntity deletarFuncionario(@PathVariable Long id_funcionario){
        var funcionario = repository.getReferenceById(id_funcionario);
        funcionario.desabilitar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalhar/{id_funcionario}")
    public ResponseEntity detalharPorId(@PathVariable Long id_funcionario){
        var funcionario = repository.getReferenceById(id_funcionario);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

}
