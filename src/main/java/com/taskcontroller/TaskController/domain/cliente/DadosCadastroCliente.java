package com.taskcontroller.TaskController.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Objects;

public final class DadosCadastroCliente {
        private final @NotNull(message = "nome nao pode ser vazio") @NotBlank String nome;
        private final @NotNull(message = "numero nao pode ser vazio") @NotBlank String numero;
        private final @NotNull(message = "telefone nao pode ser vazio")
        @NotBlank String telefone;
        private final @NotNull(message = "cep nao pode ser vazio") @NotBlank(message = "em branco") String cep;
        private final String cpf;
        private final String cnpj;

        public DadosCadastroCliente(
                @NotNull(message = "nome nao pode ser vazio")
                @NotBlank
                String nome,
                @NotNull(message = "numero nao pode ser vazio")
                @NotBlank
                String numero,
                @NotNull(message = "telefone nao pode ser vazio")
                @Pattern(regexp = "(\\d{2}) \\d{4}-\\d{4}")
                @NotBlank
                String telefone,
                @NotNull(message = "cep nao pode ser vazio")
                @NotBlank(message = "em branco")
                String cep,

                String cpf,

                String cnpj
        ) {
                this.nome = nome;
                this.numero = numero;
                this.telefone = telefone;
                this.cep = cep;
                this.cpf = cpf;
                this.cnpj = cnpj;
        }

        public @NotNull(message = "nome nao pode ser vazio") @NotBlank String nome() {
                return nome;
        }

        public @NotNull(message = "numero nao pode ser vazio") @NotBlank String numero() {
                return numero;
        }

        public @NotNull(message = "telefone nao pode ser vazio") @Pattern(regexp = "(\\d{2}) \\d{4}-\\d{4}") @NotBlank String telefone() {
                return telefone;
        }

        public @NotNull(message = "cep nao pode ser vazio") @NotBlank(message = "em branco") String cep() {
                return cep;
        }

        public @CPF String cpf() {
                return cpf;
        }

        public @CNPJ String cnpj() {
                return cnpj;
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == this) return true;
                if (obj == null || obj.getClass() != this.getClass()) return false;
                var that = (DadosCadastroCliente) obj;
                return Objects.equals(this.nome, that.nome) &&
                        Objects.equals(this.numero, that.numero) &&
                        Objects.equals(this.telefone, that.telefone) &&
                        Objects.equals(this.cep, that.cep) &&
                        Objects.equals(this.cpf, that.cpf) &&
                        Objects.equals(this.cnpj, that.cnpj);
        }

        @Override
        public int hashCode() {
                return Objects.hash(nome, numero, telefone, cep, cpf, cnpj);
        }

        @Override
        public String toString() {
                return "DadosCadastroCliente[" +
                        "nome=" + nome + ", " +
                        "numero=" + numero + ", " +
                        "telefone=" + telefone + ", " +
                        "cep=" + cep + ", " +
                        "cpf=" + cpf + ", " +
                        "cnpj=" + cnpj + ']';
        }

}
