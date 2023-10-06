package com.taskcontroller.TaskController.controller;

import com.taskcontroller.TaskController.domain.usuario.*;
import com.taskcontroller.TaskController.security.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity loginUsuario(@RequestBody DadosLogin login){
        System.out.println("Entrou na requisicao");
        var  usernamePassword = new UsernamePasswordAuthenticationToken(login.login(),login.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        System.out.println("saiu aq da requisicao");
        var token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody DadosUsuario dados){
        if (this.usuarioRepository.findByLogin(dados.login())!=null)return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario usuario = new Usuario(dados.nome(),dados.login(),encryptedPassword,dados.role());
        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/private")
    public String sayPrivate(){
        return "Este eh um endPoint private";
    }
}
