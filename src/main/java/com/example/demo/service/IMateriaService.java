package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.MateriaTO;

public interface IMateriaService {
//
//	public void insertar(Materia materia);
//
//	public Materia consultarPorCodigo(String codigo);
//
	public MateriaTO consultarPorId(Integer id);
//
//	public void actualizar(Materia materia);
//
//	public void eliminar(Integer id);

	public List<MateriaTO> consultarPorCedulaEstudiante(String cedula);

}
