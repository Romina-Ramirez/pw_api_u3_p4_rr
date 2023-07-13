package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public void insertar(Materia materia) {
		this.materiaRepository.guardar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		return this.materiaRepository.consultarPorCodigo(codigo);
	}

}
