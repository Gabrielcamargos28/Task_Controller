package com.taskcontroller.TaskController.domain.funcionario;

import com.taskcontroller.TaskController.domain.usuario.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "Funcionario")
@Table(name = "tb_Funcionario")
@PrimaryKeyJoinColumn(name = "id_funcionario")
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;
    @Column(name="telefone")
    private String telefone;
    @Column(name="cep")
    private String cep;
    @Column(name="numero")
    private String numero;
    @Column(name="email")
    private String email;


    public Funcionario(DadosCadastroFuncionario dados) {
        super(dados.nome(), dados.login(), dados.senha(), dados.role(), true);
        this.telefone = dados.telefone();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.email = dados.email();
    }
}
