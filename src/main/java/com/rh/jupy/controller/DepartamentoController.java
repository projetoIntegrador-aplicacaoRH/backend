package com.rh.jupy.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rh.jupy.model.Departamento;
import com.rh.jupy.repository.DepartamentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Departamento>> getAll(){
		return ResponseEntity.ok(departamentoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getById(@PathVariable Long id){
		return departamentoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Departamento> post(@Valid @RequestBody Departamento departamento){
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoRepository.save(departamento));
	}
	
	@PutMapping
	public ResponseEntity<Departamento> put(@Valid @RequestBody Departamento departamento){
		if(departamentoRepository.existsById(departamento.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(departamentoRepository.save(departamento));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		if(departamento.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}else {
			departamentoRepository.deleteById(id);
		}
	}
	
}
