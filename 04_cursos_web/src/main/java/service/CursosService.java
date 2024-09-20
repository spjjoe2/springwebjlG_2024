package service;

import java.util.ArrayList;

import model.Curso;

public interface CursosService { 
	
 
	public boolean nuevo(Curso curso);
	
	public ArrayList<Curso> preciosCursoMax(double precioMax);
	
	public void eliminarCurso(String nombre); 
	
	public void modificarDuracion(String nombre, int nuevaDuracion);
 
}
