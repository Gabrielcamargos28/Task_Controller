package com.taskcontroller.TaskController.service;

import com.taskcontroller.TaskController.domain.usuario.DadosLoginPesquisa;
import com.taskcontroller.TaskController.domain.usuario.Usuario;
import com.taskcontroller.TaskController.domain.usuario.UsuarioRepository;
import com.taskcontroller.TaskController.domain.validacao.ValidacaoException;
import com.taskcontroller.TaskController.domain.cliente.ClienteRepository;
import com.taskcontroller.TaskController.domain.funcionario.FuncionarioRepository;
import com.taskcontroller.TaskController.domain.tarefa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendadorDeTarefas {

    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public DadosDetalhamentoTarefa agendar(DadosAgendarTarefa dados){
        var cliente = clienteRepository.getReferenceById(dados.fk_id_cliente());
        var funcionario = funcionarioRepository.getReferenceById(dados.fk_id_funcionario());
        var tarefa = new Tarefa(null,dados.nome(),dados.descricao(),funcionario,cliente,dados.data_limite(),true,false);
        tarefaRepository.save(tarefa);
        return new DadosDetalhamentoTarefa(tarefa);
    }

    public Page<DadosDetalhamentoTarefaValidacao> mostrarTarefas(Pageable paginacao){
        Page lista = tarefaRepository.findAlByAtivoTrue(paginacao).map(DadosDetalhamentoTarefaValidacao::new);
        return lista;
    }

    public Page<DadosDetalhamentoTarefaValidacao> mostrarTarefasDeUsuario(DadosLoginPesquisa dados){
        var usuario = usuarioRepository.findByLogin(dados.login());
        Long idUsuario = usuario.getId();
        Page lista = tarefaRepository.acharTarefas(idUsuario, Pageable.ofSize(10));
        return lista;
    }

    public void desativar(DadosCancelamentoTarefa dados){
        if(!tarefaRepository.existsById(dados.id_tarefa())){
            throw new ValidacaoException("Id da tarefa inexistente");
        }
        var tarefa = tarefaRepository.getReferenceById(dados.id_tarefa());
        tarefa.cancelar();
    }

    public Tarefa validarTarefa(DadosValidarTarefa dados){
        if(!tarefaRepository.existsById(dados.id_tarefa())){
            throw new ValidacaoException("Id da tarefa inexistente");
        }
        var tarefa = tarefaRepository.getReferenceById(dados.id_tarefa());
        tarefa.validarTarefa(dados);

        return tarefa;
    }

    public Tarefa atualizarTarefa(DadosAtualizacaoTarefa dados){
        if(!tarefaRepository.existsById(dados.id())){
            throw new ValidacaoException("Id da tarefa inexistente");
        }
        var tarefa = tarefaRepository.getReferenceById(dados.id());
        tarefa.atualizarTarefa(dados);
        return tarefa;
    }

    public Tarefa detalharPorId(Long id_tarefa){
        Tarefa tarefa = tarefaRepository.getReferenceById(id_tarefa);
        return tarefa;
    }

}
