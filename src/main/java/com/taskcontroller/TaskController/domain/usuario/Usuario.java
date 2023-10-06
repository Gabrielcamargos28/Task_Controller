package com.taskcontroller.TaskController.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "role")
    private UsuarioRole role;
    @Column(name = "ativo")
    private Boolean ativo;

    private Usuario(DadosUsuario dados){
        this.nome = dados.nome();
        this.login = dados.login();
        this.senha = dados.senha();
        this.role = dados.role();
        this.ativo = true;
    }
    private Usuario(DadosLogin login){
        this.login = login.login();
        this.senha = login.senha();
    }

    public Usuario(String nome, String login, String encryptedPassword, UsuarioRole role) {
        this.nome = nome;
        this.login = login;
        this.senha = encryptedPassword;
        this.role = role;
    }

    public Usuario(String nome, String login, String senha, UsuarioRole role, boolean b) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.role = role;
        this.ativo = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        if(this.role == UsuarioRole.USER) return List.of( new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
