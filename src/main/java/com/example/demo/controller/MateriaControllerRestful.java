package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService materiaService;

	// POST
	@PostMapping(path = "/insertar")
	public void insertar(@RequestBody Materia materia) {
		this.materiaService.insertar(materia);
	}

	// GET
	@GetMapping(path = "/buscar/{codigo}")
	public Materia consultarPorCodigo(@PathVariable String codigo) {
		return this.materiaService.consultarPorCodigo(codigo);
	}

	// PUT
	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
		materia.setId(identificador);
		this.materiaService.actualizar(materia);
	}

	// PATCH
	@PatchMapping(path = "/actualizarParcial/{identificador}")
	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {
		materia.setId(identificador);
		Materia m1 = this.materiaService.consultarPorId(identificador);
		m1.setCupos(materia.getCupos());
		this.materiaService.actualizar(m1);
	}

	// DELETE
	@DeleteMapping(path = "/eliminar/{identificador}")
	public void eliminar(@PathVariable Integer identificador) {
		this.materiaService.eliminar(identificador);
	}
}
