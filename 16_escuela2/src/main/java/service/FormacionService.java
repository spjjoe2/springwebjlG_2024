package service;

import java.util.List;

import model.AlumnoDto;
import model.CursoDto;

public interface FormacionService {
	List<CursoDto> cursos();
	List<AlumnoDto> alumnos();
	List<AlumnoDto> buscarAlumnosMatriculados(int idCurso);
	List<CursoDto> buscarCursosNoMatriculado(String usuario);
	boolean altaCurso(CursoDto curso);
	boolean altaAlumno(AlumnoDto alumno);
	boolean altaAlumnoNuevo();
	AlumnoDto buscarAlumno(String usuario);
}
