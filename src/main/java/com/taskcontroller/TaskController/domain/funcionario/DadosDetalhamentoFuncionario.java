package com.taskcontroller.TaskController.domain.funcionario;

public record DadosDetalhamentoFuncionario(Long id_funcionario, String login,String nome,  String telefone, String cep, String numero, Boolean ativo){
    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId(),funcionario.getLogin(), funcionario.getNome(), funcionario.getTelefone(), funcionario.getCep(), funcionario.getNumero(),funcionario.getAtivo());
    }
}
