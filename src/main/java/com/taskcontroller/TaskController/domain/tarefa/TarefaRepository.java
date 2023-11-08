package com.taskcontroller.TaskController.domain.tarefa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Page<Tarefa> findAlByAtivoTrue(Pageable paginacao);
    @Query(
            value = "select * from tb_tarefa where fk_id_funcionario = :id_funcionario",
            nativeQuery = true
    )
    Page<Tarefa> acharTarefas(@Param("id_funcionario") Long id, Pageable pageable);
}
