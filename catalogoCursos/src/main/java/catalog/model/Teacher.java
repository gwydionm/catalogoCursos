package catalog.model;

public class Teacher {
	private int id;
	private String name;
	
	public Teacher() {}
	
	public Teacher(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public boolean equals(Object obj) {  
		Teacher teacher = (Teacher) obj;
		if (this.id != teacher.id)
			return false;
		if (!this.name.equals(teacher.getName()))
			return false;

		return true;
	}
	
	public int hashCode() {
		return id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
