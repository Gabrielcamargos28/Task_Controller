package com.taskcontroller.TaskController.domain.usuario;

public record DadosUsuario(
        String nome,
        String login,
        String senha,
        UsuarioRole role,
        Boolean ativo
) {
}
