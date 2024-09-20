package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.Curso;
import service.CursosService;
 
 

@Controller
public class CursosController {
	
	@Autowired	 
	CursosService service; 
	
	@GetMapping(value="formAlta")
	public String prepararAlta(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo";
	}
	
	
	@GetMapping(value="buscar")
	public String preciosCursoMax(@RequestParam("precioMax") double precioMax,HttpServletRequest request) {
		ArrayList<Curso> listaCursos = service.preciosCursoMax(precioMax);
		request.setAttribute("listaCursos", listaCursos);
		return "cursos";
	}	
	
	@PostMapping(value="nuevo")
	public String altaCurso(@ModelAttribute Curso curso) {		
		return service.nuevo(curso)?"nuevo":"error";
	}	
	
	
	@PostMapping(value="eliminar")
	public String eliminarCurso(@RequestParam("nombre") String nombre) {
		service.eliminarCurso(nombre);
		return "menu";
		
	}
	//las navegaciones estáticas están en el archivo de configuración del controller
	
}