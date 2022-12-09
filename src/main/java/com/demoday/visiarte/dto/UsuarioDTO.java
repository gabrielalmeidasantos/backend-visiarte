package com.demoday.visiarte.dto;

import com.demoday.visiarte.domain.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nome_usuario;
    private String nome_completo;
    private String bio;
    private String data_nascimento;
    private String email;
    private String senha;
    private String foto_perfil;
    private String foto_capa;
    private int quant_seguidores;
    private int quant_seguindo;

    public UsuarioDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getFoto_capa() {
        return foto_capa;
    }

    public void setFoto_capa(String foto_capa) {
        this.foto_capa = foto_capa;
    }

    public int getQuant_seguidores() {
        return quant_seguidores;
    }

    public void setQuant_seguidores(int quant_seguidores) {
        this.quant_seguidores = quant_seguidores;
    }

    public int getQuant_seguindo() {
        return quant_seguindo;
    }

    public void setQuant_seguindo(int quant_seguindo) {
        this.quant_seguindo = quant_seguindo;
    }

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId();
        nome_usuario = usuario.getNome_usuario();
        nome_completo = usuario.getNome_completo();
        bio = usuario.getBio();
        data_nascimento = usuario.getData_nascimento();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        foto_perfil = usuario.getFoto_perfil();
        foto_capa = usuario.getFoto_capa();
        quant_seguidores = usuario.getQuant_seguidores();
        quant_seguindo = usuario.getQuant_seguindo();;
    }

}
