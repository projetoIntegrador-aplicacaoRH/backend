package com.rh.jupy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rh.jupy.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{
	
	public List <Funcionario> findBynomeContainingIgnoreCase(@Param("nome")String nome);
	public List <Funcionario> findBycargoContainingIgnoreCase(@Param("cargo")String cargo);
	public List <Funcionario> findByDate(@Param("admissao")Date date);
	public List <Funcionario> findBysalario(@Param("salario")Float salario);
}
