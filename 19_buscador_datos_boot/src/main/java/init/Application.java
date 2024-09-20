package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories(basePackages = {"dao"})
@EntityScan(basePackages  = {"entities"})
@SpringBootApplication(scanBasePackages=  {"service","controller","utilidades"})
public class Application implements WebMvcConfigurer{   
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/toBuscar").setViewName("buscar");
		registry.addViewController("/toNuevo").setViewName("nuevo");
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/toInicio").setViewName("menu");
		registry.addViewController("/toEliminar").setViewName("eliminar");		 
		WebMvcConfigurer.super.addViewControllers(registry);
	}

}
 
