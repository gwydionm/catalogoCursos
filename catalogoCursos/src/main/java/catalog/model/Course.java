package catalog.model;

public class Course {
	private boolean active;
	private int teacherID;
	private String title;
	private int hours;
	private String level;
	private int id;
	
	public Course() {}
	
	public Course(String title, String level, boolean active, int hours, int teacherID) {
		this.active = active;
		this.teacherID = teacherID;
		this.title = title;
		this.hours = hours;
		this.level = level;
	}
	
	public boolean equals(Object obj) {  
		Course course = (Course) obj;
		if (this.active != course.isActive())
			return false;
		if (this.teacherID != course.getTeacherID())
				return false;
		if (!this.title.equals(course.getTitle()))
			return false;
		if (this.hours != course.getHours())
			return false;
		if (!this.level.equals(course.getLevel()))
			return false;

		return true;
	}
	
	public int hashCode() {
		return 0; //write a function to get INT from string
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean activo) {
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
