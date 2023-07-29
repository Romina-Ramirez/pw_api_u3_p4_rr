package com.example.demo.service;

import com.example.demo.repository.modelo.Curso;

public interface ICursoService {

	public void insertar(Curso curso);

	public Curso consultarPorId(Integer id);

	public void actualizar(Curso curso);

	public void actualizarParcial(String codigoActual, String codigoNuevo);

	public void eliminar(Integer id);

}
