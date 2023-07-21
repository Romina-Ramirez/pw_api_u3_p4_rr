package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante consultarPorCedula(String cedula);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String cedulaActual, String nuevaCedula);

	public void eliminar(Integer id);

	public Estudiante consultarPorID(Integer id);

	public List<Estudiante> consultarTodos(String provincia);

}
