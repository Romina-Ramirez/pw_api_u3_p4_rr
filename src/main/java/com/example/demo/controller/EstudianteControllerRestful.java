package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.consultarPorCedula(cedula);
	}

	@GetMapping
	public ResponseEntity<List<Estudiante>> consultarTodos(@RequestParam String provincia) {
		// ?provincia=Pichincha
		List<Estudiante> lista = this.estudianteService.consultarTodos(provincia);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
		cabeceras.add("valorAPI", "Incalculable");
		return new ResponseEntity<>(lista, cabeceras, 228);
	}

//	// POST
//	@PostMapping(consumes = "application/xml")
//	public void insertar(@RequestBody Estudiante estudiante) {
//		this.estudianteService.insertar(estudiante);
//	}
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces =  MediaType.APPLICATION_XML_VALUE)
	public Estudiante insertarYConsultar(@RequestBody Estudiante estudiante) {
		return this.estudianteService.insertarEstudiante(estudiante);
	}

	// PUT
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	// PATCH
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		Estudiante e1 = this.estudianteService.consultarPorID(identificador);
		this.estudianteService.actualizarParcial(e1.getCedula(), estudiante.getCedula());
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}
}
