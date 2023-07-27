package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

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
	public List<Estudiante> consultarTodosPorProvincia(String provincia) {
		return this.estudianteRepository.buscarTodosPorProvincia(provincia);
	}

	@Override
	public void actualizarParcial(String cedulaActual, String nuevaCedula) {
		this.estudianteRepository.actualizarParcial(cedulaActual, nuevaCedula);
	}

	@Override
	public Estudiante insertarEstudiante(Estudiante estudiante) {
		return this.estudianteRepository.guardarEstudiante(estudiante);
	}

	@Override
	public List<EstudianteTO> consultarTodos() {
		List<Estudiante> lista = this.estudianteRepository.buscarTodos();
		List<EstudianteTO> listaTO = lista.stream().map(estudiante -> this.convertir(estudiante))
				.collect(Collectors.toList());
		return listaTO;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estu = new EstudianteTO();
		estu.setApellido(estudiante.getApellido());
		estu.setCedula(estudiante.getCedula());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		estu.setNombre(estudiante.getNombre());
		estu.setProvincia(estudiante.getProvincia());
		estu.setId(estudiante.getId());
		return estu;
	}

}
