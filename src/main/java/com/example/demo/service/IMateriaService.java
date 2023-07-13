package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {

	public void insertar(Materia materia);

	public Materia buscarPorCodigo(String codigo);

}
