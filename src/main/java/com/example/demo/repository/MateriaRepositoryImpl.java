package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedula) {
		TypedQuery<Materia> myQuery = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula = :datoCedula", Materia.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getResultList();
	}

	@Override
	public Materia buscarPorId(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}

//	@Override
//	public void guardar(Materia materia) {
//		this.entityManager.persist(materia);
//	}
//
//	@Override
//	public Materia buscarPorCodigo(String codigo) {
//		TypedQuery<Materia> myQuery = this.entityManager
//				.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo", Materia.class);
//		myQuery.setParameter("datoCodigo", codigo);
//		return myQuery.getSingleResult();
//	}
//
//
//	@Override
//	public void actualizar(Materia materia) {
//		this.entityManager.merge(materia);
//	}
//
//	@Override
//	public void actualizarParcial(Integer cuposActual, Integer nuevosCupos) {
//		Query myQuery = this.entityManager
//				.createQuery("UPDATE Materia m SET m.cupos =:datoCupos WHERE m.codigo =:datoCondicion");
//		myQuery.setParameter("datoCupos", nuevosCupos);
//		myQuery.setParameter("datoCondicion", cuposActual);
//		myQuery.executeUpdate();
//	}
//
//	@Override
//	public void borrar(Integer id) {
//		this.entityManager.remove(this.buscarPorId(id));
//	}
}
