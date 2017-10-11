package catalog.model;

public class Course {
	private int id;
	private int active;
	private int teacherID;
	private String title;
	private int hours;
	private String level;
	private String file;
	private boolean hasFile;
	
	
	public Course(int id, String title, String level, int active, int hours, int teacherID, String file) {
		this.id = id;
		this.active = active;
		this.teacherID = teacherID;
		this.title = title;
		this.hours = hours;
		this.level = level;
		this.file = file;
		this.hasFile = !file.equals("");
	}
	
	public boolean equals(Object obj) {  
		if (obj==null)
			return false;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		Course course = (Course) obj;
		if (active != course.isActive())
			return false;
		if (teacherID != course.getTeacherID())
				return false;
		if (!title.equals(course.getTitle()))
			return false;
		if (hours != course.getHours())
			return false;
		if (file != course.getFile())
			return false;
		// Last check
		return this.level.equals(course.getLevel());
	}
	
	public boolean getHasFile() {
		return hasFile;
	}
	
	public void setFile(String file) {
		this.file=file;
	}
	
	public String getFile() {
		return file;
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
