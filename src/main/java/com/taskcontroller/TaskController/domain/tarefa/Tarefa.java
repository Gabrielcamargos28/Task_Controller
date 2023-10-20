package com.taskcontroller.TaskController.domain.tarefa;

import com.taskcontroller.TaskController.domain.cliente.Cliente;
import com.taskcontroller.TaskController.domain.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name="Tarefa")
@Table(name="tb_tarefa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tarefa")
    private Long id_tarefa;
    @Column(name="nome")
    private String nome;
    @Column(name="descricao")
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_funcionario")
    private Funcionario funcionario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_id_cliente")
    private Cliente cliente;
    @Column(name="data_limite")
    private LocalDateTime data_limite;
    @Column(name="ativo")
    private Boolean ativo;

    public void cancelar(){
        this.ativo = false;
    }
}
