package com.taskcontroller.TaskController.domain.funcionario;

public record DadosAtualizacaoFuncionario(
        Long id,
        String nome,
        String login,
        String email,
        String telefone,
        String cep,
        String numero
) {
}
