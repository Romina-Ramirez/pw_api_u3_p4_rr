package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {

	public void guardar(Materia materia);

	public Materia consultarPorCodigo(String codigo);

}
