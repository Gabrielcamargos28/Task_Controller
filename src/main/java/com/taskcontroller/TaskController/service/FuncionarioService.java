package com.taskcontroller.TaskController.service;

import com.taskcontroller.TaskController.domain.funcionario.DadosCadastroFuncionario;
import com.taskcontroller.TaskController.domain.funcionario.DadosDetalhamentoFuncionario;
import com.taskcontroller.TaskController.domain.funcionario.Funcionario;
import com.taskcontroller.TaskController.domain.funcionario.FuncionarioRepository;
import com.taskcontroller.TaskController.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosDetalhamentoFuncionario cadastrarFuncionario(DadosCadastroFuncionario dados){
        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        Funcionario funcionario = new Funcionario(dados.nome(),dados.login(),encryptedPassword,dados.role(),dados.telefone(), dados.cep(), dados.email(), dados.numero() );
        repository.save(funcionario);

        return new DadosDetalhamentoFuncionario(funcionario);
    }
}
