package com.taskcontroller.TaskController.controller;

import com.taskcontroller.TaskController.domain.funcionario.*;
import com.taskcontroller.TaskController.domain.tarefa.DadosDetalhamentoTarefa;
import com.taskcontroller.TaskController.domain.tarefa.DadosValidarTarefa;
import com.taskcontroller.TaskController.domain.tarefa.Tarefa;
import com.taskcontroller.TaskController.domain.usuario.Usuario;
import com.taskcontroller.TaskController.service.AgendadorDeTarefas;
import com.taskcontroller.TaskController.service.FuncionarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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


@SecurityRequirement(name = "BearerToken")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;
    @Autowired
    private FuncionarioRepository repository;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrarFuncionario(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriBuilder){
        DadosDetalhamentoFuncionario funcionario = service.cadastrarFuncionario(dados);
        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.id()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(new Funcionario(dados)));
    }

    @GetMapping("/listarfuncionarios")
    public ResponseEntity<Page<DadosDetalhamentoFuncionario>> listarFuncionarios(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        var page = repository.findByAtivoTrue(paginacao).map(DadosDetalhamentoFuncionario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/atualizarfuncionario")
    @Transactional
    public ResponseEntity atualizarFuncionario(@RequestBody DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarFuncionario(dados);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @DeleteMapping("/desativarfuncionario/{id}")
    @Transactional
    public ResponseEntity deletarFuncionario(@PathVariable Long id){
        var funcionario = repository.getReferenceById(id);
        funcionario.desabilitar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalhar/{id_funcionario}")
    public ResponseEntity detalharPorId(@PathVariable Long id_funcionario){
        var funcionario = repository.getReferenceById(id_funcionario);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }
}
