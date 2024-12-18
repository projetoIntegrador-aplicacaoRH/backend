package com.rh.jupy.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rh.jupy.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{
	
	public List <Funcionario> findByNomeContainingIgnoreCase(@Param("nome")String nome);
	public List <Funcionario> findByCargoContainingIgnoreCase(@Param("cargo")String cargo);
	public List <Funcionario> findByAdmissao(@Param("admissao")Date admissao);
	public List <Funcionario> findByValorHora(@Param("valorHora")BigDecimal valorHora);
}
