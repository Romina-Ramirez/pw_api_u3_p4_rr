package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {

//	public void guardar(Materia materia);
//
//	public Materia buscarPorCodigo(String codigo);
//
	public Materia buscarPorId(Integer id);
//
//	public void actualizar(Materia materia);
//
//	public void actualizarParcial(Integer cuposActual, Integer nuevosCupos);
//
//	public void borrar(Integer id);

	public List<Materia> buscarPorCedulaEstudiante(String cedula);

}
