package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
import model.AlumnoDto;
import model.CursoDto;
import utilidades.Mapeador;
@Service
public class FormacionServiceImpl implements FormacionService {
	
	CursosDao cursosDao;
	AlumnosDao alumnosDao;
	Mapeador mapeador;
	

	public FormacionServiceImpl(CursosDao cursosDao, AlumnosDao alumnosDao, Mapeador mapeador) {
		this.cursosDao = cursosDao;
		this.alumnosDao = alumnosDao;
		this.mapeador=mapeador;
	}
	//esta anotaciÃ³n se pone para evitar que hibernate cierre la sesiÃ³n al obtener el objeto principal
	//y asÃ­ no falle cuando se recuperen los objetos relacionados 
	@Transactional
	@Override
	public List<CursoDto> cursos() {
		return cursosDao.findAll().stream()
				.map(c->mapeador.cursoEntityToDto(c))
				.toList(); 
	}
	
	@Transactional
	@Override
	public List<AlumnoDto> alumnos() {
		return alumnosDao.findAll().stream()
				.map(a->mapeador.alumnoEntityToDto(a)) 
				.toList(); 
	}

	@Override
	public List<AlumnoDto> buscarAlumnosMatriculados(int idCurso) {
		return alumnosDao.findByIdCurso(idCurso).stream()
				.map(a->mapeador.alumnoEntityToDto(a))
				.toList(); 
	}
	
	@Override
	public List<CursoDto> buscarCursosNoMatriculado(String usuario) {
		return cursosDao.findByNoMatriculado(usuario).stream()
				.map(c->mapeador.cursoEntityToDto(c))
				.toList(); 
	}
	
	
	@Override
	public boolean altaCurso(CursoDto curso) {
		if(cursosDao.findByNombreAndFechaInicio(curso.getNombre(), curso.getFechaInicio())==null) {
			cursosDao.save(mapeador.cursoDtoToEntity(curso));
			return true;
		}
		return false;
	}
	
	public boolean altaAlumno(AlumnoDto alumno) {
		
		if(alumnosDao.findById(alumno.getUsuario()).isEmpty()) {
			alumnosDao.save(mapeador.alumnoDtoToEntity(alumno));
			return true;
		}
		return false;
		
	}	
	public AlumnoDto buscarAlumno(String usuario) {
		alumnosDao.findAllById(usuario);
	};
		
  

}

