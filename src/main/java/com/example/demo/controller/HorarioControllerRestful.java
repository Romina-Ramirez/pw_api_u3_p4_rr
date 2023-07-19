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

import com.example.demo.repository.modelo.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestful {

	@Autowired
	private IHorarioService horarioService;

	// POST
	@PostMapping
	public void insertar(@RequestBody Horario horario) {
		this.horarioService.insertar(horario);
	}

	// GET
	@GetMapping(path = "/{identificador}")
	public Horario consultarPorId(@PathVariable Integer identificador) {
		return this.horarioService.consultarPorId(identificador);
	}

	// PUT
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);
		this.horarioService.actualizar(horario);
	}

	// PATCH
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);
		Horario h1 = this.horarioService.consultarPorId(identificador);
		this.horarioService.actualizarParcial(h1.getCurso(), horario.getCurso());
	}

	// DELETE
	@DeleteMapping(path = "/{identificador}")
	public void eliminar(@PathVariable Integer identificador) {
		this.horarioService.eliminar(identificador);
	}

}
