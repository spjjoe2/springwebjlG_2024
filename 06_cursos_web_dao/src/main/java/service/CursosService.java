package service;

import java.util.List;

import model.Curso;

public interface CursosService {

	//modificar este mÃ©todo para que aÃ±ada el curso si no hay otro
	//con el mismo nombre, si ya existe no se aÃ±ade y se devuelve false
	boolean nuevo(Curso curso);

	List<Curso> preciosCursoMax(double precioMax);

	void eliminarCurso(String nombre);

}