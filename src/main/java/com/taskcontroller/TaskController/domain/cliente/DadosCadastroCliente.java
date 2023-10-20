package com.taskcontroller.TaskController.domain.cliente;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotNull(message = "nome nao pode ser vazio")
        String nome,
        @NotNull(message = "numero nao pode ser vazio")
        String numero,
        @NotNull(message = "telefone nao pode ser vazio")
        String telefone,
        @NotNull(message = "cep nao pode ser vazio")
        String cep,
        @NotEmpty
        String cpf,
        @NotEmpty
        String cnpj
) {
}
