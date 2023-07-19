package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Horario horario) {
		this.entityManager.persist(horario);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public void actualizar(Horario horario) {
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String cursoActual, String cursoNuevo) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Horario h SET h.curso =:datoCurso WHERE h.curso =:datoCondicion");
		myQuery.setParameter("datoCurso", cursoNuevo);
		myQuery.setParameter("datoCondicion", cursoActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}

}
