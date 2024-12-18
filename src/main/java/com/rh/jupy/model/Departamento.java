package com.rh.jupy.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome não pode estar em branco.")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
  private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("departamento")
	private List<Funcionario> funcionarios;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("departamento")
	private List<Funcionario> funcionarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
