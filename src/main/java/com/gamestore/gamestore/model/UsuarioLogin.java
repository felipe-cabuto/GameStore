package com.gamestore.gamestore.model;

import java.time.LocalDateTime;

public class UsuarioLogin {

    private Long id;

    private int usuario;

    private String nome;

    private String senha;

    private String foto;

    private LocalDateTime data_nascimento;

    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public LocalDateTime getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDateTime data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
