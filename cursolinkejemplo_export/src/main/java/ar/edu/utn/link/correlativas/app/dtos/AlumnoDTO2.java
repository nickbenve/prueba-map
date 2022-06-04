package ar.edu.utn.link.correlativas.app.dtos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import ar.edu.utn.link.correlativas.model.Alumno;

@Projection(name = "alumno2",types = {Alumno.class})
public interface AlumnoDTO2 {

	String getNombre();
	
	
	
	String getApellido();
	
	@Value("slslslsla")
	String getAlgo();
	
}
