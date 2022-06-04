package ar.edu.utn.link.correlativas.app;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.link.correlativas.app.dtos.AlumnoDTO;
import ar.edu.utn.link.correlativas.app.dtos.AlumnoDTO2;
import ar.edu.utn.link.correlativas.model.Alumno;

@RepositoryRestResource(path="alumnos",excerptProjection = AlumnoDTO.class)
public interface RepoAlumno extends PagingAndSortingRepository<Alumno, Integer> {

	Optional<AlumnoDTO2> findByNombre(String nombre);
	
	@RestResource(exported = false)
	Page<Alumno> findByNombreAndApellido(String nombre,String apellido,Pageable page);
	
	@Override	
	@RestResource(exported = false)
	void deleteById(Integer id) ;
	
	@Override
	@RestResource(exported = false)
	void delete(Alumno entity) ;


	
}
