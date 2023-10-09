package com.taskcontroller.TaskController.domain.cliente;

public record DadosDetalhamentoCliente(Long id_cliente,String nome,String telefone, String cep, String numero,String cpf, String cnpj,Boolean ativo) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId_cliente(),cliente.getNome(),cliente.getTelefone(),cliente.getCep(),cliente.getNumero(),cliente.getCpf(),cliente.getCnpj(),cliente.getAtivo());
    }
}
