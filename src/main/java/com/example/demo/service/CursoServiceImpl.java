package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICursoRepository;
import com.example.demo.repository.modelo.Curso;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoRepository cursoRepository;

	@Override
	public void insertar(Curso curso) {
		this.cursoRepository.guardar(curso);
	}

	@Override
	public Curso consultarPorId(Integer id) {
		return this.cursoRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Curso curso) {
		this.cursoRepository.actualizar(curso);
	}

	@Override
	public void actualizarParcial(String codigoActual, String codigoNuevo) {
		this.cursoRepository.actualizarParcial(codigoActual, codigoNuevo);
	}

	@Override
	public void eliminar(Integer id) {
		this.cursoRepository.borrar(id);
	}

}
