package com.taskcontroller.TaskController.domain.tarefa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Page<Tarefa> findAlByAtivoTrue(Pageable paginacao);
}
