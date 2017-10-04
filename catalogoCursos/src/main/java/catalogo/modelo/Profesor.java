package catalogo.modelo;

public class Profesor {
	private int id;
	private String nombre;
	
	public Profesor() {}
	
	public Profesor(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public boolean equals(Object obj) {  
		Profesor profesor = (Profesor) obj;
		if (this.id != profesor.id)
			return false;
		if (!this.nombre.equals(profesor.getNombre()))
			return false;

		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
