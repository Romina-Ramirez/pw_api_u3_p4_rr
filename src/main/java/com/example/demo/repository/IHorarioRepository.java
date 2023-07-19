package com.example.demo.repository;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioRepository {
	
	public void guardar(Horario horario);

	public Horario buscarPorId(Integer id);

	public void actualizar(Horario horario);

	public void actualizarParcial(String cursoActual, String cursoNuevo);

	public void borrar(Integer id);

}
