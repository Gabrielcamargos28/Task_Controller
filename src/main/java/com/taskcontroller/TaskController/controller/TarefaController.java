package com.taskcontroller.TaskController.controller;


import com.taskcontroller.TaskController.domain.tarefa.DadosAgendarTarefa;
import com.taskcontroller.TaskController.domain.tarefa.DadosCancelamentoTarefa;
import com.taskcontroller.TaskController.domain.tarefa.DadosDetalhamentoTarefa;
import com.taskcontroller.TaskController.service.AgendadorDeTarefas;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@SecurityRequirement(name = "BearerToken")
@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
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

    @DeleteMapping("desabilitartarefa")
    @Transactional
    public ResponseEntity desabilitar(@RequestBody @Valid DadosCancelamentoTarefa dados){
        agendadorDeTarefas.desativar(dados);
        System.out.println(dados);
        return ResponseEntity.ok().build();
    }
}
