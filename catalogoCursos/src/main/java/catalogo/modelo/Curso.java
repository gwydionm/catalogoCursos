package catalogo.modelo;

public class Curso {
	private int id;
	private String activo;
	private int idProfesor;
	private String titulo;
	private int horas;
	private String nivel;
	
	public Curso() {}
	
	public Curso(int id, String titulo, String nivel, String activo, int horas, int idProfesor) {
		this.id = id;
		this.activo = activo;
		this.idProfesor = idProfesor;
		this.titulo = titulo;
		this.horas = horas;
		this.nivel = nivel;
	}
	
	public boolean equals(Object obj) {  
		Curso curso = (Curso) obj;
		if (this.id != curso.id)
			return false;
		if (!this.activo.equals(curso.getActivo()))
			return false;
		if (this.idProfesor != curso.getIdProfesor())
				return false;
		if (!this.titulo.equals(curso.getTitulo()))
			return false;
		if (this.horas != curso.getHoras())
			return false;
		if (!this.nivel.equals(curso.getNivel()))
			return false;

		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
