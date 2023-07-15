package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {

	public void insertar(Materia materia);

	public Materia consultarPorCodigo(String codigo);

	public Materia consultarPorId(Integer id);

	public void actualizar(Materia materia);

	public void eliminar(Integer id);

}
