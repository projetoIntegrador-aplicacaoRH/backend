package com.rh.jupy.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome não pode estar em branco.")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
	private String nome;

	@NotNull(message = "O salário não pode ser nulo.")
	@DecimalMin(value = "0.0", inclusive = true, message = "O salário deve ser no mínimo 0.0.")
	@DecimalMax(value = "100000.0", inclusive = true, message = "O salário não pode ser maior que 100000.0.")
	private BigDecimal valorHora;

	@DecimalMin(value = "0.0", inclusive = true, message = "O desconto deve ser no mínimo 0.0.")
	@DecimalMax(value = "5000.0", inclusive = true, message = "O desconto não pode ser maior que 5000.0.")
	private BigDecimal desconto;
	
	@DecimalMin(value = "0.0", inclusive = true, message = "O bônus deve ser no mínimo 0.0.")
	@DecimalMax(value = "5000.0", inclusive = true, message = "O bônus não pode ser maior que 5000.0.")
	private BigDecimal bonus;

	@NotNull(message = "As horas trabalhadas não podem ser nulas.")
	@Min(value = 0, message = "As horas trabalhadas devem ser no mínimo 0.")
	@Max(value = 200, message = "As horas trabalhadas não podem ser maiores que 200.")
	private Integer horasTrabalhadas;

	@NotBlank(message = "O cargo não pode estar em branco.")
	@Size(min = 2, max = 30, message = "O cargo deve ter entre 2 e 30 caracteres.")
	private String cargo;

	@NotNull(message = "A data de admissão não pode ser nula.")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date admissao;

	@ManyToOne
	@JsonIgnoreProperties("funcionarios")
	private Usuario usuario;

	@ManyToOne
	@JsonIgnoreProperties("funcionarios")
	private Departamento departamento;

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

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	
	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
