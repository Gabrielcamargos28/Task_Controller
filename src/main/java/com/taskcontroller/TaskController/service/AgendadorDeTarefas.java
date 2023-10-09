package com.taskcontroller.TaskController.service;

import com.taskcontroller.TaskController.domain.validacao.ValidacaoException;
import com.taskcontroller.TaskController.domain.cliente.ClienteRepository;
import com.taskcontroller.TaskController.domain.funcionario.FuncionarioRepository;
import com.taskcontroller.TaskController.domain.tarefa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgendadorDeTarefas {

    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public DadosDetalhamentoTarefa agendar(DadosAgendarTarefa dados){
        var cliente = clienteRepository.getReferenceById(dados.fk_id_cliente());
        var funcionario = funcionarioRepository.getReferenceById(dados.fk_id_funcionario());
        var tarefa = new Tarefa(null, dados.nome(), dados.descricao(),funcionario,cliente,dados.data_limite(),true);
        System.out.println("Tarefa:"+tarefa);
        tarefaRepository.save(tarefa);
        return new DadosDetalhamentoTarefa(tarefa);
    }

    public Page<DadosDetalhamentoTarefa> mostrarTarefas(Pageable paginacao){
        var page = tarefaRepository.findAlByAtivoTrue(paginacao).map(DadosDetalhamentoTarefa::new);
        return page;
    }

    public void desativar(DadosCancelamentoTarefa dados){
        if(!tarefaRepository.existsById(dados.id_tarefa())){
            throw new ValidacaoException("Id da tarefa inexistente");
        }
        var tarefa = tarefaRepository.getReferenceById(dados.id_tarefa());
        tarefa.cancelar();
    }

}
