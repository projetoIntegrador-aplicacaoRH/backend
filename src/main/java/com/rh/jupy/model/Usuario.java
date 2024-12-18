package com.rh.jupy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O atributo 'nome' deve ser preenchido.")
	@Size(max = 255, message = "O atributo 'nome' deve conter no máximo 255 caracteres.")
	private String nome;

	@Email(message = "O atributo 'usuario' deve ser um email válido.")
	@NotBlank(message = "O atributo 'usuario' deve ser preenchido.")
	private String usuario;

	@Size(max = 5000, message = "O atributo 'foto' pode conter no máximo 5000 caracteres.")
	private String foto;

	@Size(min = 8, message = "O atributo 'senha' deve conter no minimo 8 caracteres.")
	@NotBlank(message = " O atributo 'senha' deve ser preenchido.")
	private String senha;

	
	
	
	
	
	public Usuario(Long id, String nome, String usuario, String senha, String foto) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
