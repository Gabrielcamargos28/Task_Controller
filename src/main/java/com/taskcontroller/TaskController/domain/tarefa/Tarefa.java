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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_id_funcionario")
    private Funcionario funcionario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fk_id_cliente")
    private Cliente cliente;
    @Column(name="data_limite")
    private LocalDateTime data_limite;

    @Column(name = "ass_administrado")
    private String ass_administrador;

    @Column(name = "ass_cliente")
    private String ass_cliente;

    @Column(name = "validada")
    private Boolean validada;
    
    @Column(name="ativo")
    private Boolean ativo;

    public Tarefa(Long id_tarefa, String nome, String descricao, Funcionario funcionario, Cliente cliente, LocalDateTime data_limite, boolean ativo, boolean validada) {
        this.id_tarefa = id_tarefa;
        this.nome = nome;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data_limite = data_limite;
        this.ativo = true;
        this.validada = false;
    }

    public void validarTarefa(DadosValidarTarefa dados){
        this.ass_administrador = dados.ass_administrador();
        this.ass_cliente = dados.ass_cliente();
        if(!dados.ass_administrador().isEmpty() && !dados.ass_cliente().isEmpty()){
            this.validada = true;
        }
        this.ativo = true;
    }
    public void atualizarTarefa(DadosAtualizacaoTarefa dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }

    public void cancelar(){
        this.ativo = false;
    }
}
