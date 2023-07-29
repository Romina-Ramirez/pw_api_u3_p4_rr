package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Curso;
import com.example.demo.service.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoControllerRestful {

	@Autowired
	private ICursoService cursoService;

	// GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> consultarPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(this.cursoService.consultarPorId(id), null, 200);
	}

	// POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void insertar(@RequestBody Curso curso) {
		this.cursoService.insertar(curso);
	}

	// PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody Curso curso, @PathVariable Integer id) {
		curso.setId(id);
		this.cursoService.actualizar(curso);
	}

	// PATCH
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizarParcial(@RequestBody Curso curso, @PathVariable Integer id) {
		curso.setId(id);
		Curso c1 = this.cursoService.consultarPorId(id);
		this.cursoService.actualizarParcial(c1.getCodigo(), curso.getCodigo());
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Integer id) {
		this.cursoService.eliminar(id);
	}
}
