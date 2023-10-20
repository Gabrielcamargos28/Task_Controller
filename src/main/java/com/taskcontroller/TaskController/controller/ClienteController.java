package com.taskcontroller.TaskController.controller;

import com.taskcontroller.TaskController.domain.cliente.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.annotation.Retention;


@SecurityRequirement(name = "BearerToken")
@RequestMapping("/clientes")
@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId_cliente()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }
    @GetMapping("/listarclientes")
    public ResponseEntity<Page<DadosDetalhamentoCliente>> listarClientes(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAlByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/atualizarcliente")
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id_cliente());
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/desativarcliente/{id_cliente}")
    @Transactional
    public ResponseEntity desabilitarCliente(@PathVariable Long id_cliente){
        var cliente = repository.getReferenceById(id_cliente);
        cliente.desabilitar();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/detalhar/{id_cliente}")
    public ResponseEntity detalharPorId(@PathVariable Long id_cliente){
        var cliente = repository.getReferenceById(id_cliente);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}
