package com.taskcontroller.TaskController.domain.cliente;

public record DadosAtualizacaoCliente(
        Long id_cliente,
        String nome,
        String telefone,
        String cep,
        String numero,
        String cpf,
        String cnpj
){
}
