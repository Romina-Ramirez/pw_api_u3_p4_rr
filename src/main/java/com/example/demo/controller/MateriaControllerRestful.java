package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping(path = "/buscar")
	public Materia buscarPorCodigo() {
		String codigo = "PW_CR_08_01";
		return this.materiaService.buscarPorCodigo(codigo);
	}

}
