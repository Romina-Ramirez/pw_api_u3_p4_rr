package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante consultarPorCedula(String cedula) {
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		this.estudianteRepository.guardar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepository.borrar(id);
	}

	@Override
	public Estudiante consultarPorID(Integer id) {
		return this.estudianteRepository.buscarPorID(id);
	}

	@Override
	public List<Estudiante> consultarTodos(String provincia) {
		return this.estudianteRepository.buscarTodos(provincia);
	}

	@Override
	public void actualizarParcial(String cedulaActual, String nuevaCedula) {
		this.estudianteRepository.actualizarParcial(cedulaActual, nuevaCedula);
	}

	@Override
	public Estudiante insertarEstudiante(Estudiante estudiante) {
		return this.estudianteRepository.guardarEstudiante(estudiante);
	}

}
