package catalog.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import catalog.dao.CourseDAO;
import catalog.dao.TeacherDAO;
import catalog.model.Course;
import catalog.model.Level;
import catalog.model.Teacher;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class MainController implements Serializable {

	public static final Logger LOGGER = Logger.getLogger( MainController.class.getName() );

	private static final long serialVersionUID = 3973801993975443027L;

	private CourseDAO daoCourses;
	private TeacherDAO daoTeachers;

	private transient List<Course> courses;
	private transient List<Teacher> teachers;
	private List<String> nameOfTeachers;

	private List<String> levels;

	private String teacher;
	private boolean active;
	private String title;
	private String level;
	private int hours;


	public MainController() {
		daoCourses = new CourseDAO();
		daoTeachers = new TeacherDAO();
		init();
	}
	/*
	public MainController(CourseDAO courseDAO, TeacherDAO teacherDAO) {
		daoCourses = courseDAO;
		daoTeachers = teacherDAO;
		init();
	}*/

	private void init() {
		courses = daoCourses.selectActives();
		teachers = daoTeachers.selectAll();
		nameOfTeachers = new ArrayList<>();
		for (Teacher p : teachers)
			nameOfTeachers.add(p.getName());

		levels = new ArrayList<>();
		for (Level l : Level.values())
			levels.add(l.toString());

		resetValues();
	}

	public void newCourse() {
		int teacherID=0;
		for (Teacher t : teachers)
			if (t.getName().equals(teacher))
				teacherID = t.getId();
		
		Course curso = new Course(1, title, level, (active ? 1 : 0), hours, teacherID);
		if (active)
			courses.add(curso);
		daoCourses.insert(curso);

		resetValues();
	}

	public void resetValues() {
		this.title="";
		this.active=false;
		this.hours = 0;
		this.level = "";
		this.teacher = "";
	}

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<String> getNameOfTeachers() {
		return nameOfTeachers;
	}
	public void setNameOfTeachers(List<String> nameOfTeachers) {
		this.nameOfTeachers = nameOfTeachers;
	}

	public List<String> getLevels() {
		return levels;
	}
	public void setLevels(List<String> levels) {
		this.levels = levels;
	}

	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}


}
