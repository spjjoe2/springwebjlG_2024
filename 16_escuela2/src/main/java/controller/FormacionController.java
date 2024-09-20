package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.AlumnoDto;
import model.CursoDto;
import service.FormacionService;

@Controller
public class FormacionController {
	FormacionService formacionService;

	public FormacionController(FormacionService formacionService) {
		this.formacionService = formacionService;
	}
	@GetMapping(value="consulta")
	public String inicial(Model model) {
		model.addAttribute("cursos", formacionService.cursos());
		return "cursos";
	}
	
	@GetMapping(value="buscarAlumnosPorCurso",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnosPorCurso(@RequestParam("idCurso") int idCurso){
		
		return formacionService.buscarAlumnosMatriculados(idCurso);
	} 
	
	@PostMapping(value="altaCurso",produces=MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String altaCurso(@ModelAttribute CursoDto curso){
		return String.valueOf(formacionService.altaCurso(curso));
	}
	
	@GetMapping(value="listaAlumnos",produces=MediaType.APPLICATION_JSON_VALUE) 
	public String   listaAlumnos(Model model){
		model.addAttribute("alumnos",formacionService.alumnos());
		return  "altaAlumno";
	}
	@GetMapping(value="listaCursosNoMatriculado",produces=MediaType.APPLICATION_JSON_VALUE)
	public String listaCursosNoMatriculado(Model model,@RequestParam("idUsuario") String idUsuario){
		model.addAttribute("idUsuario",idUsuario);
		model.addAttribute("cursosNoMatriculado",formacionService.buscarCursosNoMatriculado(idUsuario));
		return  "altaAlumno";
	 
	}
	@GetMapping(value="cursoNoMatriculado",produces=MediaType.APPLICATION_JSON_VALUE)
	public String cursoNoMatriculado(Model model,@RequestParam("idCurso") String idCurso){
		model.addAttribute("idCurso",idCurso);		 
		return  "altaAlumno";	 
	}
	
	
	@GetMapping(value="listaCursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> listaCursos(){
		return  formacionService.cursos();
	}	
	
	@PostMapping(value="matriculaAlumno",produces=MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String matriculaAlumno(@ModelAttribute AlumnoDto alumno){
		if(formacionService.buscarAlumno(alumno)==null) {
			:
		}else {
			
		}
		
		return String.valueOf(formacionService.altaAlumno(alumno));
	}
	
 
}
