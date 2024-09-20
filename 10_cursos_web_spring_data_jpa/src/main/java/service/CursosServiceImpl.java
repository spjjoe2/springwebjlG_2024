package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.CursosDao;
import entities.Curso;
import model.CursoDto;
import utilidades.Mapeador;


@Service
 
public class CursosServiceImpl implements CursosService{ 
	
	CursosDao cursosDao;
	Mapeador mapeador;
	public CursosServiceImpl(CursosDao cursosDao, Mapeador mapeador) {
		this.cursosDao = cursosDao;
		this.mapeador = mapeador;
	}

	
	public boolean nuevo(CursoDto curso) {	
		 
		if(cursosDao.findByNombre(curso.getNombre())==null){
			Curso c =mapeador.cursoDtoToEntity(curso);	  
			cursosDao.save(c);
			return true;
		}
		return false;
	}
		
	
	public List<CursoDto> preciosCursoMax(double precioMax){
			List<Curso> cursos = cursosDao.findByPrecioMax(precioMax);
			List<CursoDto> listaCursosDto = new ArrayList();					
			for(Curso c:cursos) {
				CursoDto cdto =mapeador.cursoEntityToDto(c);
				listaCursosDto.add(cdto); 
			}
			return listaCursosDto;
	}
	
	public void eliminarCurso(String nombre) {
		cursosDao.deleteByNombre(nombre); 
	}	
	

	public void modificarDuracion(String nombre, int nuevaDuracion) {
		cursosDao.modificarDuracion(nombre, nuevaDuracion);		
 
	}
}

