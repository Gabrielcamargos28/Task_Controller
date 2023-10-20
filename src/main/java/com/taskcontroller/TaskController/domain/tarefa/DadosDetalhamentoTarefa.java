package com.taskcontroller.TaskController.domain.tarefa;

import java.time.LocalDateTime;

public record DadosDetalhamentoTarefa(Long id_tarefa,
                                      String nome,
                                      String descricao,
                                      Long fk_id_cliente,
                                      Long fk_id_funcionario,
                                      LocalDateTime data_limite,
                                      String nome_funcionario,
                                      String nome_cliente,
                                      Boolean ativo
) {
    public DadosDetalhamentoTarefa (Tarefa tarefa){
        this(tarefa.getId_tarefa(), tarefa.getNome(),tarefa.getDescricao(),
                tarefa.getCliente().getId_cliente(),tarefa.getFuncionario().getId(),
                tarefa.getData_limite(), tarefa.getFuncionario().getNome(), tarefa.getCliente().getNome(), tarefa.getAtivo());
    }
}
