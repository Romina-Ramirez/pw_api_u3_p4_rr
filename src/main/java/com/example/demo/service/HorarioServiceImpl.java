package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	public void insertar(Horario horario) {
		this.horarioRepository.guardar(horario);
	}

	@Override
	public Horario consultarPorId(Integer id) {
		return this.horarioRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Horario horario) {
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public void actualizarParcial(String cursoActual, String cursoNuevo) {
		this.horarioRepository.actualizarParcial(cursoActual, cursoNuevo);
	}

	@Override
	public void eliminar(Integer id) {
		this.horarioRepository.borrar(id);
	}

}
