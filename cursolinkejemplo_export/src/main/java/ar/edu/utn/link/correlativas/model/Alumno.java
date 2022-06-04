package ar.edu.utn.link.correlativas.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Alumno {
	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
		
	private String apellido;
	
	
	
	@Transient
	private List<Curso> cursos;
	
	
	@ManyToMany
	private Collection<Materia>  materiasAprobadas;
	
	
		
	protected Alumno() {
		super();
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public Collection<Materia> getMateriasAprobadas() {
		return  materiasAprobadas;
	}
	public void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}
	
	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void inscribir(Curso curso) {
		if(curso.estaIncripto(this)) {
			throw new InscripcionException("ya esta inscripto",curso,this);
		}
		curso.anotar(this);
	}
	
	
	

}
