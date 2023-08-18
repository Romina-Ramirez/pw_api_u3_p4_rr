package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Curso;

@Repository
@Transactional
public class CursoRepositoryImpl implements ICursoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Curso curso) {
		this.entityManager.persist(curso);
	}

	@Override
	public Curso buscarPorId(Integer id) {
		return this.entityManager.find(Curso.class, id);
	}

	@Override
	public void actualizar(Curso curso) {
		this.entityManager.merge(curso);
	}

	@Override
	public void actualizarParcial(String codigoActual, String codigoNuevo) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Curso c SET c.codigo =:datoCodigo WHERE c.codigo =:datoCondicion");
		myQuery.setParameter("datoCodigo", codigoNuevo);
		myQuery.setParameter("datoCondicion", codigoActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}

}
