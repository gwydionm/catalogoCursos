package catalog.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import catalog.dao.CourseDAO;
import catalog.dao.TeacherDAO;
import catalog.model.Course;
import catalog.model.Level;
import catalog.model.Teacher;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class MainController implements Serializable {
	
	private static final String FILES_PATH = "/Users/Gwydion/eclipse-workspace/catalogoCursos/StoredFiles/";

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
	private UploadedFile file;


	public MainController() {		
		daoCourses = new CourseDAO();
		daoTeachers = new TeacherDAO();
		init();
	}
	
	public MainController(CourseDAO courseDAO, TeacherDAO teacherDAO) {
		daoCourses = courseDAO;
		daoTeachers = teacherDAO;
		init();
	}

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
	
	public void handleFileUpload(FileUploadEvent event) {
		file = event.getFile();
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public UploadedFile getFile() {
		return file;
	}
	
	public void showFile(String file) {
		try {
			Desktop.getDesktop().open(new File(FILES_PATH+file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newCourse() {
		int teacherID=0;
		for (Teacher t : teachers) 
			if (t.getName().equals(teacher)) {
				teacherID = t.getId();
				break;
			}
		
		// Copy file
		if (file!=null && !file.getFileName().equals("")) {
			InputStream in=null; OutputStream out=null;
			try {
				in = file.getInputstream();
				out = new FileOutputStream(new File(FILES_PATH+file.getFileName()));
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = in.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in!=null)
						in.close();  
					if (out!=null)
						out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		Course curso = new Course(1, title, level, (active ? 1 : 0), hours, teacherID, (file==null ? "" : file.getFileName()));
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
		this.file=null;
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
