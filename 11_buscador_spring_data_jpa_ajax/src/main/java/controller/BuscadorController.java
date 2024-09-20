package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.ResultadoDto;
import service.BuscadorService;

@Controller
public class BuscadorController {
	
	@Autowired
	@Qualifier("buscadorEstandar")
	BuscadorService service;
	
	@GetMapping(value="buscar",produces="application/json")
	public @ResponseBody List<ResultadoDto>  buscarResultados(@RequestParam("tematica") String tematica) {
		return service.buscar(tematica);	 
		 
	}
	/*@PostMapping(value="alta")
	public String altaResultado(@RequestParam("url") String url,
								@RequestParam("tematica") String tematica,
								@RequestParam("descripcion") int descripcion) {
		Resultado resultado=new Resultado(url,tematica,descripcion);
		return service.agregar(resultado)?"inicio":"error";
	}*/
	@PostMapping(value="alta")
	public String altaResultado(@ModelAttribute ResultadoDto resultado) {
		
		return service.agregar(resultado)?"inicio":"error";
	}
	
	@GetMapping(value="buscarUno",produces="application/json") 
	public @ResponseBody ResultadoDto  buscarResultado(@RequestParam("url") String url) {
		return service.buscarPorUrl(url); 
	}
	
 
	
	
	
	
	
	@PostMapping(value="eliminar")
	public String eliminarResultado(@RequestParam("url") String url) {
		service.eliminar(url);
		return "inicio";
	}
	//las navegaciones estÃ¡ticas estÃ¡n en el archivo de configuraciÃ³n del controller
	
}
