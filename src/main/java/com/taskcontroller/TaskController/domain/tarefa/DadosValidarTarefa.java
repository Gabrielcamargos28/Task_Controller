package com.taskcontroller.TaskController.domain.tarefa;

import java.time.LocalDateTime;

public record DadosValidarTarefa(
        Long id_tarefa,
        String ass_administrador,
        String ass_cliente
){
}
