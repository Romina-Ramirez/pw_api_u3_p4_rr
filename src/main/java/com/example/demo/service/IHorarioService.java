package com.example.demo.service;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioService {

	public void insertar(Horario horario);

	public Horario consultarPorId(Integer id);

	public void actualizar(Horario horario);

	public void actualizarParcial(String cursoActual, String cursoNuevo);

	public void eliminar(Integer id);

}
