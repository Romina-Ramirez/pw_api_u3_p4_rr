package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IMateriaService;
import com.example.demo.service.MateriaServiceImpl;
import com.example.demo.service.to.MateriaTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;


@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaTO> buscarPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(this.materiaService.consultarPorId(id), null, 200) ;
	}
	
//	// POST
//	@PostMapping(path = "/insertar")
//	public void insertar(@RequestBody Materia materia) {
//		this.materiaService.insertar(materia);
//	}
//
//	// GET
//	@GetMapping(path = "/buscar/{codigo}")
//	public Materia consultarPorCodigo(@PathVariable String codigo) {
//		return this.materiaService.consultarPorCodigo(codigo);
//	}
//
//	// PUT
//	@PutMapping(path = "/actualizar/{identificador}")
//	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
//		materia.setId(identificador);
//		this.materiaService.actualizar(materia);
//	}
//
//	// PATCH
//	@PatchMapping(path = "/actualizarParcial/{identificador}")
//	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {
//		materia.setId(identificador);
//		Materia m1 = this.materiaService.consultarPorId(identificador);
//		// m1.setCupos(materia.getCupos());
//		this.materiaService.actualizar(m1);
//	}
//
//	// DELETE
//	@DeleteMapping(path = "/eliminar/{identificador}")
//	public void eliminar(@PathVariable Integer identificador) {
//		this.materiaService.eliminar(identificador);
//	}
}
