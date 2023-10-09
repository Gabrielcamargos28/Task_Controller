package com.taskcontroller.TaskController.domain.funcionario;

import com.taskcontroller.TaskController.domain.usuario.Usuario;

import com.taskcontroller.TaskController.domain.usuario.UsuarioRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Funcionario")
@Table(name = "tb_Funcionario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@PrimaryKeyJoinColumn(name="id_usuario")
public class Funcionario extends Usuario {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;*/
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

    public Funcionario(String nome, String login, String encryptedPassword, UsuarioRole role,String telefone,String cep,String email,String numero) {
        super(nome, login,encryptedPassword, role, true);
        this.telefone = telefone;
        this.cep = cep;
        this.numero = numero;
        this.email = email;
    }

    public void atualizarFuncionario(DadosAtualizacaoFuncionario dados){
        super.setNome(dados.nome());
        this.telefone = dados.telefone();
        this.cep = dados.cep();
        this.numero = dados.numero();
    }
    public void desabilitar() {
        this.setAtivo(false);
    }
}
