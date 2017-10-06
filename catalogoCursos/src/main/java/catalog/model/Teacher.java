package catalog.model;

public class Teacher {
	private int id;
	private String name;
	
	public Teacher(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public boolean equals(Object obj) {  
		if (obj == null)
			return false;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		Teacher teacher = (Teacher) obj;
		if (this.id != teacher.id)
			return false;
		// Last check
		return this.name.equals(teacher.getName());
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
