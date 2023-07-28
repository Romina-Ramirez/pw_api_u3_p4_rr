package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public List<MateriaTO> consultarPorCedulaEstudiante(String cedula) {
		List<Materia> lista = this.materiaRepository.buscarPorCedulaEstudiante(cedula);
		List<MateriaTO> listaTO = lista.stream().map(materia -> this.convertir(materia)).collect(Collectors.toList());
		return listaTO;
	}

	@Override
	public MateriaTO consultarPorId(Integer id) {
		Materia mate = this.materiaRepository.buscarPorId(id);
		return this.convertir(mate);
	}

	private MateriaTO convertir(Materia materia) {
		MateriaTO mate = new MateriaTO();
		mate.setId(materia.getId());
		mate.setNombre(materia.getNombre());
		mate.setNumeroCreditos(materia.getNumeroCreditos());
		return mate;
	}

//	@Override
//	public void insertar(Materia materia) {
//		this.materiaRepository.guardar(materia);
//	}
//
//	@Override
//	public Materia consultarPorCodigo(String codigo) {
//		return this.materiaRepository.buscarPorCodigo(codigo);
//	}
//
//
//	@Override
//	public void actualizar(Materia materia) {
//		this.materiaRepository.actualizar(materia);
//	}
//
//	@Override
//	public void eliminar(Integer id) {
//		this.materiaRepository.borrar(id);
//	}

}
