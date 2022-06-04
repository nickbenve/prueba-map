package ar.edu.utn.link.correlativas.app;

import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Curso;
import ar.edu.utn.link.correlativas.model.InscripcionException;
import ar.edu.utn.link.correlativas.model.RepoCurso;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

@RepositoryRestController
public class AlumnoControllerComplement {

	@Autowired
	RepoAlumno repoAlumno;
	
	@Autowired
	RepoCurso repoCurso;
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST,value="/alumnos/{alumnoId}/inscribir")
	@ResponseBody
	public String inscribir(
			@PathVariable("alumnoId") Integer alumnoId,
			@RequestBody Map<String, Object> body) {

		String cursoId=body.get("cursoId").toString();
		Integer a= Integer.parseInt(cursoId);
		
		Optional<Alumno> opcionalAlumno = repoAlumno.findById(alumnoId);
		if(opcionalAlumno.isEmpty()) {
			return "alumno no encontrado";
		}
		Alumno alumno = opcionalAlumno.get();
		
		Optional<Curso> opcionalCurso = repoCurso.findById(a);
		if(opcionalAlumno.isEmpty()) {
			return "alumno no encontrado";
		}
		Curso curso = opcionalCurso.get();
		
		//-----------------------------
		try 
		{
			alumno.inscribir(curso);
		} catch(InscripcionException ex) {
			return "el alumno ya esta inscripto";
		}
		//-----------------------------------
		
		return "ok";
	}

}
