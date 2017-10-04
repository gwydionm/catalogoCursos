package catalogo.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import catalogo.dao.CursoDAO;
import catalogo.dao.ProfesorDAO;
import catalogo.modelo.Curso;
import catalogo.modelo.Profesor;

@ManagedBean
@SessionScoped
public class MainController implements Serializable {

	private static final long serialVersionUID = 3973801993975443027L;
	
	private CursoDAO daoCursos;
	private ProfesorDAO daoProfesores;

	private List<Curso> cursosActivos;
	private List<Profesor> profesores;
	private List<String> nombresProfesores;

	private List<String> niveles;
	
	private String profesor;
	private boolean activo;
	private String titulo;
	private String nivel;
	private int horas;


	public MainController() {
		daoCursos = new CursoDAO();
		List<Curso> cursos = daoCursos.selectAll();
		daoProfesores = new ProfesorDAO();
		profesores = daoProfesores.selectAll();
		nombresProfesores = new ArrayList<String>();
		for (Profesor p : profesores)
			nombresProfesores.add(p.getNombre());
		cursosActivos = new ArrayList<Curso>();
		for (Curso c : cursos)
			if (c.getActivo().equalsIgnoreCase("si"))
				cursosActivos.add(c);
		
		niveles = new ArrayList<String>();
		niveles.add("Básico");
		niveles.add("Intermedio");
		niveles.add("Avanzado");
		
		resetValues();
	}
	
	public void nuevoCurso(ActionEvent actionEvent) {
		int id_profe = buscaProfesor();
		Curso curso = new Curso(daoCursos.selectAll().size()+1, titulo, nivel, (activo ? "si" : "no"), horas, id_profe);
		if (activo)
			cursosActivos.add(curso);
		daoCursos.insert(curso);
		
		resetValues();
	}
	
	public int buscaProfesor() {
		for (Profesor p : profesores) 
			if (p.getNombre().equals(profesor))
				return p.getId();
		return 0;
	}
	
	public void resetValues() {
		this.titulo="";
		this.activo=false;
		this.horas = 0;
		this.nivel = "";
		this.profesor = "";
	}
	
	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public List<Curso> getCursos() {
		return this.cursosActivos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursosActivos = cursos;
	}
	
	public List<Profesor> getProfesores() {
		return this.profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public List<String> getNiveles() {
		return this.niveles;
	}

	public void setNiveles(List<String> niveles) {
		this.niveles = niveles;
	}

	public List<String> getNombresProfesores() {
		return nombresProfesores;
	}

	public void setNombresProfesores(List<String> nombresProfesores) {
		this.nombresProfesores = nombresProfesores;
	}
}