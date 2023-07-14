package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/buscar/{cedula}")
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
//	@GetMapping(path = "/buscarTodos")
//	public List<Estudiante> consultarTodos(){
//		return this.estudianteService.consultarTodos();
//	}
	
	@GetMapping(path = "/buscarTodos")
	public List<Estudiante> consultarTodos(@RequestParam String provincia){
		//buscarTodos?provincia=Pichincha
		return this.estudianteService.consultarTodos(provincia);
	}

	// POST
	@PostMapping(path = "/insertar")
	public void insertar(@RequestBody Estudiante estudiante) {
		this.estudianteService.insertar(estudiante);
	}

	// PUT
	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	// PATCH
	@PatchMapping(path = "/actualizarParcial/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		Estudiante e1 = this.estudianteService.consultarPorID(identificador);
		e1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(e1);
	}

	// DELETE
	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}
}
