package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;

public interface CursosDao extends JpaRepository<Curso,Integer> {	 
		
		@Query("select c from Curso c where c.precio<=?1")
		public List<Curso> findByPrecioMax(double precio);
		
		@Transactional
		@Modifying
		public void deleteByNombre(String nombre); 
		
		@Transactional
		@Modifying
		@Query("update Curso  c set c.duracion=?1   where c.nombre=?2") 
		public void modificarDuracion(String nombre, int nuevaDuracion);
		
		public Curso findByNombre(String nombre);

}
