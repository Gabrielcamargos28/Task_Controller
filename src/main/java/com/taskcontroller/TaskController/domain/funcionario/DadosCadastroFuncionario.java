package com.taskcontroller.TaskController.domain.funcionario;

import com.taskcontroller.TaskController.domain.usuario.Usuario;
import com.taskcontroller.TaskController.domain.usuario.UsuarioRole;

public record DadosCadastroFuncionario(
        String nome,
        String login,
        String senha,
        UsuarioRole role,
        String telefone,
        String cep,
        String numero,
        String email

) {
}
