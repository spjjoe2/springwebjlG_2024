package dao;

import java.util.List;

import entities.Curso;

public interface CursosDao {	
	 
		public void nuevo(Curso curso);
		
		public List<Curso> preciosCursoMax(double precioMax);
		
		public void eliminarCurso(String nombre); 
		
		public void modificarDuracion(String nombre, int nuevaDuracion);
		public Curso findByName(String nombre);

}
