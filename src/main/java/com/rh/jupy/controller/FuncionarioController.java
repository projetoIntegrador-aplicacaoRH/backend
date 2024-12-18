package com.rh.jupy.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rh.jupy.model.Funcionario;
import com.rh.jupy.repository.DepartamentoRepository;
import com.rh.jupy.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@GetMapping
	public ResponseEntity<List<Funcionario>> getAll() {
		return ResponseEntity.ok(funcionarioRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Long id) {
		return funcionarioRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Funcionario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(funcionarioRepository.findBynomeContainingIgnoreCase(nome));
	}

	@GetMapping("/cargo/{cargo}")
	public ResponseEntity<List<Funcionario>> getByCargo(@PathVariable String cargo) {
		return ResponseEntity.ok(funcionarioRepository.findBycargoContainingIgnoreCase(cargo));
	}

	@GetMapping("/salario/{salario}")
	public ResponseEntity<List<Funcionario>> getBySalario(@PathVariable Float salario) {
		return ResponseEntity.ok(funcionarioRepository.findBysalario(salario));
	}

	@GetMapping("/date/{date}")
	public ResponseEntity<List<Funcionario>> getByDate(@PathVariable Date date) {
		return ResponseEntity.ok(funcionarioRepository.findByDate(date));

	}

	@PostMapping
	public ResponseEntity<Funcionario> post(@Valid @RequestBody Funcionario funcionario) {
		if (departamentoRepository.existsById(funcionario.getDepartamento().getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insira um departamento válido.");
	}

	@PutMapping
	public ResponseEntity<Funcionario> put(@Valid @RequestBody Funcionario funcionario) {
		if (departamentoRepository.existsById(funcionario.getDepartamento().getId())) {
			return funcionarioRepository.findById(funcionario.getId()).map(
					resposta -> ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario)))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insira um departamento válido.");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		funcionarioRepository.deleteById(id);
	}
}
