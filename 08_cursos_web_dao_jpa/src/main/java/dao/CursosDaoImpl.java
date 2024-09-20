package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

 

@Repository
public class CursosDaoImpl implements CursosDao {

	@PersistenceContext
	EntityManager eManager;
	
	@Transactional
	@Override
	public void nuevo(Curso curso) {
		eManager.persist(curso);
	}

	@Override
	public List<Curso> preciosCursoMax(double precioMax) {
		String jpql="select c from Curso  c where c.precio<=?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql, Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
		
	}

	@Transactional	
	public void eliminarCurso(String nombre) {
		String jpql="delete from Curso  c where c.nombre=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		String jpql="update Curso  c set c.duracion=?1   where c.nombre=?2";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, nuevaDuracion);
		query.setParameter(2, nombre);
		query.executeUpdate();

	}
	
	public Curso findByName(String nombre) {
		String jpql="select c from Curso c where c.nombre=?1";
		TypedQuery<Curso> query= eManager.createQuery(jpql, Curso.class);
		query.setParameter(1, nombre);
		return query.getResultList().stream()
				.findFirst()
				.orElse(null);
	}
	

}
