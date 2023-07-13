package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1723069801";
		return this.estudianteService.consultarPorCedula(cedula);
	}

	// POST
	@PostMapping(path = "/insertar")
	public void insertar(@RequestBody Estudiante estudiante) {
		this.estudianteService.insertar(estudiante);
	}

	// PUT
	@PutMapping(path = "/actualizar")
	public void actualizar() {
	}

	// PATCH
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {
	}

	// DELETE
	@DeleteMapping(path = "/eliminar")
	public void eliminar() {
	}
}
