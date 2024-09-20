package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.CursoDto;
import service.CursosService;
 
 

@Controller
public class CursosController {
	
	@Autowired	 
	CursosService service; 
	
	@RequestMapping(value="formAlta")
	public String prepararAlta(Model model) {
		model.addAttribute("curso", new CursoDto());
		return "nuevo";
	}
	
	
	@GetMapping(value="buscar")
	public String preciosCursoMax(@RequestParam("precioMax") double precioMax,HttpServletRequest request) {
		List<CursoDto> listaCursos = service.preciosCursoMax(precioMax);
		request.setAttribute("listaCursos", listaCursos);
		return "cursos";
	}	
	
	@PostMapping(value="nuevo")
	public String altaCurso(@ModelAttribute CursoDto curso) {		
		return service.nuevo(curso)?"forward:/formAlta":"error";
	}	
	
	
	@PostMapping(value="eliminar")
	public String eliminarCurso(@RequestParam("nombre") String nombre) {
		service.eliminarCurso(nombre);
		return "menu";
		
	}
	//las navegaciones estáticas están en el archivo de configuración del controller
	
}