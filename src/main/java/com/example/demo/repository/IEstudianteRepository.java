package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);

	public Estudiante guardarEstudiante(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String cedulaActual, String nuevaCedula);

	public void borrar(Integer id);

	public Estudiante buscarPorID(Integer id);

	public List<Estudiante> buscarTodosPorProvincia(String provincia);

	public List<Estudiante> buscarTodos();

}
