package ar.edu.utn.link.correlativas.app.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;

@Projection(name = "alumno1",types = {Alumno.class})
public interface AlumnoDTO {

	String getNombre();
	
	
	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();
	
	@Value("#{target.materiasAprobadas.size()}")
	int getCantMateriasAprobadas();
	
	@Value("#{target.materiasAprobadas}")
	List<Materia> getMateriasAprobadas();
	
}
