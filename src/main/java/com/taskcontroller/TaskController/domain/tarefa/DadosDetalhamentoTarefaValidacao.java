package com.taskcontroller.TaskController.domain.tarefa;

import java.time.LocalDateTime;

public record DadosDetalhamentoTarefaValidacao(Long id_tarefa,
                                      String nome,
                                      String descricao,
                                      Long fk_id_cliente,
                                      Long fk_id_funcionario,
                                      LocalDateTime data_limite,
                                      String nome_funcionario,
                                      String nome_cliente,
                                      String ass_cliente,
                                      String ass_administrador,
                                      Boolean validada
) {
    public DadosDetalhamentoTarefaValidacao (Tarefa tarefa){
        this(tarefa.getId_tarefa(),tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getFuncionario().getId(),
                tarefa.getCliente().getId_cliente(),
                tarefa.getData_limite(),
                tarefa.getFuncionario().getNome(),
                tarefa.getCliente().getNome(),
                tarefa.getAss_cliente(),
                tarefa.getAss_administrador(),
                tarefa.getValidada());
    }

}
