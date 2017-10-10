package catalog.model;

public class Course {
	private int id;
	private int active;
	private int teacherID;
	private String title;
	private int hours;
	private String level;
	
	
	public Course(int id, String title, String level, int active, int hours, int teacherID) {
		this.id = id;
		this.active = active;
		this.teacherID = teacherID;
		this.title = title;
		this.hours = hours;
		this.level = level;
	}
	
	public boolean equals(Object obj) {  
		if (obj==null)
			return false;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		Course course = (Course) obj;
		if (this.active != course.isActive())
			return false;
		if (this.teacherID != course.getTeacherID())
				return false;
		if (!this.title.equals(course.getTitle()))
			return false;
		if (this.hours != course.getHours())
			return false;
		// Last check
		return this.level.equals(course.getLevel());
	}
	
	public int hashCode() {
		int code = 0;
		for (int i=0; i<title.length(); i++)
			code+= title.charAt(i)*(10^i);
		return code;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public int isActive() {
		return active;
	}

	public void setActive(int activo) {
		this.active = activo;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
