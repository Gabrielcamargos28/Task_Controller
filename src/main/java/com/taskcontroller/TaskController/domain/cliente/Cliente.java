package com.taskcontroller.TaskController.domain.cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name="Cliente")
@Table(name="tb_Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long id_cliente;
    @Column(name="nome")
    private String nome;
    @Column(name="telefone")
    private String telefone;
    @Column(name="cep")
    private String cep;
    @Column(name="numero")
    private String numero;
    @Column(name="cpf")
    private String cpf;
    @Column(name="cnpj")
    private String cnpj;

    @Column(name="ativo")
    private Boolean ativo;
    public Cliente(DadosCadastroCliente dados){
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cpf = dados.cpf();
        this.cnpj = dados.cnpj();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cpf = dados.cpf();
        this.cnpj = dados.cnpj();
    }
    public void desabilitar(){
        this.ativo = false;
    }
}
