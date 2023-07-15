package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		TypedQuery<Materia> myQuery = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo", Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public Materia buscarPorId(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
	}

	@Override
	public void actualizarParcial(Integer cuposActual, Integer nuevosCupos) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Materia m SET m.cupos =:datoCupos WHERE m.codigo =:datoCondicion");
		myQuery.setParameter("datoCupos", nuevosCupos);
		myQuery.setParameter("datoCondicion", cuposActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}
}
