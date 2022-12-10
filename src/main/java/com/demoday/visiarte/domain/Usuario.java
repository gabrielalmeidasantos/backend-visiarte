package com.demoday.visiarte.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
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

	private String senhaCriptografada;
	
	public Usuario() {
		
	}

	public Usuario(String id, String nome_usuario, String nome_completo, String bio, String data_nascimento,
			String email, String senha, String foto_perfil, String foto_capa, int quant_seguidores,
			int quant_seguindo) {
		super();
		this.id = id;
		this.nome_usuario = nome_usuario;
		this.nome_completo = nome_completo;
		this.bio = bio;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.senha = senha;
		this.foto_perfil = foto_perfil;
		this.foto_capa = foto_capa;
		this.quant_seguidores = quant_seguidores;
		this.quant_seguindo = quant_seguindo;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome_usuario, other.nome_usuario);
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
	
	
}