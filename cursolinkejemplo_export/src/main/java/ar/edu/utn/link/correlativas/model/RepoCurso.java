package ar.edu.utn.link.correlativas.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path="cursos")
public interface RepoCurso extends PagingAndSortingRepository<Curso, Integer> {

}
