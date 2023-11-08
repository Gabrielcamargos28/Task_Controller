package com.taskcontroller.TaskController.domain.funcionario;

import com.taskcontroller.TaskController.domain.usuario.Usuario;
import com.taskcontroller.TaskController.domain.usuario.UsuarioRole;
import jakarta.validation.constraints.*;

public record DadosCadastroFuncionario(
        String nome,
        @NotNull
        String login,
        @NotNull
                @NotBlank
        String senha,
        @NotNull
        UsuarioRole role,

        @NotNull(message = "telefone nao pode ser vazio")
        //@Pattern(regexp = "(\\d{2}) \\d{4}-\\d{4}")
        @NotBlank
        String telefone,
        @NotNull(message = "cep nao pode ser vazio")
        @NotBlank(message = "em branco")
        String cep,

        String numero,
        @Email
        String email

) {
}
