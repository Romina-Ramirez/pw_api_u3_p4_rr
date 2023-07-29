package com.example.demo.repository;

import com.example.demo.repository.modelo.Curso;

public interface ICursoRepository {

	public void guardar(Curso curso);

	public Curso buscarPorId(Integer id);

	public void actualizar(Curso curso);

	public void actualizarParcial(String codigoActual, String codigoNuevo);

	public void borrar(Integer id);

}
