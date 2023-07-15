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
	public Materia consultarPorCodigo(String codigo) {
		return this.materiaRepository.buscarPorCodigo(codigo);
	}

	@Override
	public Materia consultarPorId(Integer id) {
		return this.materiaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Materia materia) {
		this.materiaRepository.actualizar(materia);
	}

	@Override
	public void eliminar(Integer id) {
		this.materiaRepository.borrar(id);
	}

}
