package com.taskcontroller.TaskController.controller;


import com.taskcontroller.TaskController.domain.funcionario.DadosAtualizacaoFuncionario;
import com.taskcontroller.TaskController.domain.funcionario.DadosDetalhamentoFuncionario;
import com.taskcontroller.TaskController.domain.tarefa.*;
import com.taskcontroller.TaskController.domain.usuario.DadosLoginPesquisa;
import com.taskcontroller.TaskController.domain.usuario.Usuario;
import com.taskcontroller.TaskController.domain.validacao.ValidacaoException;
import com.taskcontroller.TaskController.service.AgendadorDeTarefas;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;


@SecurityRequirement(name = "BearerToken")
@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private AgendadorDeTarefas agendadorDeTarefas;


    @PostMapping("agendartarefa")
    @Transactional
    public ResponseEntity agendarTarefa(@RequestBody DadosAgendarTarefa dados, UriComponentsBuilder uriBuilder){

        var dto = agendadorDeTarefas.agendar(dados);
        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(dto.id_tarefa()).toUri();
        return ResponseEntity.ok().build();
    }

    @GetMapping("mostrartarefas")
    public Page<DadosDetalhamentoTarefa> mostrarTarefas(Pageable paginacao){
        var page = agendadorDeTarefas.mostrarTarefas(paginacao);
        return page;
    }
    @PostMapping("mostrartarefasexpecificas")
    public Page<Tarefa> mostrarTarefasDeUsuario(@RequestBody DadosLoginPesquisa dados){
        Page lista = agendadorDeTarefas.mostrarTarefasDeUsuario(dados);
        return lista;
    }
    @DeleteMapping("desabilitartarefa")
    @Transactional
    public ResponseEntity desabilitar(@RequestBody @Valid DadosCancelamentoTarefa dados){
        agendadorDeTarefas.desativar(dados);
        System.out.println(dados);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizartarefa")
    @Transactional
    public ResponseEntity atualizarTarefa(@RequestBody DadosAtualizacaoTarefa dados){
        Tarefa tarefa = agendadorDeTarefas.atualizarTarefa(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTarefa(tarefa));
    }

    @PutMapping("/validartarefa")
    @Transactional
    public ResponseEntity validarTarefa(@RequestBody DadosValidarTarefa dados){
        agendadorDeTarefas.validarTarefa(dados);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/detalhar/{id_tarefa}")
    public ResponseEntity detalharPorId(@PathVariable Long id_tarefa){
        var tarefa = agendadorDeTarefas.detalharPorId(id_tarefa);
        return ResponseEntity.ok(new DadosDetalhamentoTarefaValidacao(tarefa));
    }
}
