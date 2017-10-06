package catalog.unitary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import catalog.dao.CourseDAO;
import catalog.dao.TeacherDAO;
import catalog.model.Course;
import catalog.model.Level;
import catalog.model.Teacher;
import catalog.view.MainController;

public class UnitTest {
	
	List<Course> courses;
	List<Teacher> teachers;
	List<String> gotten;
	List<String> names;
	List<String> levels;
	
	@Before
	public void init() {
		courses =  new ArrayList<Course>();
		courses.add(new Course("a", "Basic", true, 25, 1));
		courses.add(new Course("b", "Basic", true, 25, 1));
		courses.add(new Course("c", "Basic", true, 25, 1));
		
		teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher(1,"juan"));
		teachers.add(new Teacher(2,"luis"));
		
		names = new ArrayList<String>();
		names.add("juan");
		names.add("luis");   	

		levels = new ArrayList<String>();
		for (Level l : Level.values())
			levels.add(l.toString());
	}

	@Test
	public void emptyControllerTest() {
	    	// Creation of controller
	    MainController m = new MainController();
	    assertNull(m.getNameOfTeachers());
	    m.setNameOfTeachers(names);
	
	    gotten = m.getNameOfTeachers();
	    assertTrue(names.size()==gotten.size());
	    for (int i=0; i<names.size(); i++)
	    		assertTrue(names.get(i).equals(gotten.get(i)));
	    
	    m.setTeachers(new ArrayList<Teacher>());
	    assertTrue(m.searchTeacher()==0);
    
	}
	
    @Test
    public void normalControllerTest()  {
	    	CourseDAO daoCourseMock = mock(CourseDAO.class); 
	    	when(daoCourseMock.selectActives()).thenReturn(courses);
	    	TeacherDAO daoTeacherMock = mock(TeacherDAO.class);
	    	when(daoTeacherMock.selectAll()).thenReturn(teachers);

	    	// Creation of controller using parameters
	    	MainController m = new MainController(daoCourseMock, daoTeacherMock);
        
        // Setters
        assertFalse(m.isActive());
        m.setActive(true);
        assertTrue(m.isActive());
        
        m.setCourses(null);
        assertNull(m.getCourses());
        m.setCourses(courses);
        
        m.setTeachers(null);
        assertNull(m.getTeachers());
        m.setTeachers(teachers);
        
        assertTrue(m.getHours()==0);
        m.setHours(25);
        assertTrue(m.getHours()==25);

        assertTrue(m.getLevel().equals(""));
        m.setLevel("lelele");
        assertTrue(m.getLevel().equals("lelele"));
        
        assertTrue(m.getTeacher().equals(""));
        m.setTeacher("tetete");
        assertTrue(m.getTeacher().equals("tetete"));
        
        assertTrue(m.getTitle().equals(""));
        m.setTitle("tititi");
        assertTrue(m.getTitle().equals("tititi"));
        
        m.setLevels(null);
        assertNull(m.getLevels());
        m.setLevels(levels);
        gotten = m.getLevels();
        assertTrue(levels.size()==gotten.size());
        for (int i=0; i<levels.size(); i++)
        		assertTrue(levels.get(i).equals(gotten.get(i)));
        
        // search teacher
        m.setTeacher("");
        assertTrue(m.searchTeacher()==0);
        Teacher t = teachers.get(1);
        m.setTeacher(t.getName());
        assertTrue(m.searchTeacher()==t.getId());
        
        // new course
        m.newCourse();
        verify(daoCourseMock).insert(any(Course.class));
        m.setActive(false);
        m.newCourse();
        verify(daoCourseMock, times(2)).insert(any(Course.class));
        
    }
    
	@Test
	public void courseTest() {
		String title = "aaa";
		boolean active = true;
		int teacherID = 1;
		int hours = 25;
		String level = "bbb";
		
	    	Course c = new Course(title, level, active, hours, teacherID);
	    	Course c2 = new Course(title, level, active, hours, teacherID);
	    	
	    	assertFalse(c.equals(null));
	    	assertFalse(c.equals(1));
	    	
	    	c2.setTitle("abc");
	    	assertTrue(c2.getTitle().equals("abc"));
	    	assertFalse(c.equals(c2));
	    	assertTrue(c.hashCode()!=c2.hashCode());
	    	c2.setTitle(title);
	    	
	    	c2.setActive(false);
	    	assertFalse(c2.isActive());
	    	assertFalse(c.equals(c2));
	    	c2.setActive(active);
	    	
	    	c2.setTeacherID(-4);
	    	assertTrue(c2.getTeacherID()==-4);
	    	assertFalse(c.equals(c2));
	    	c2.setTeacherID(teacherID);
	    	
	    	c2.setHours(-10);
	    	assertTrue(c2.getHours()==-10);
	    	assertFalse(c.equals(c2));
	    	c2.setHours(hours);
	    	
	    	c2.setLevel("impossible");
	    	assertTrue(c2.getLevel().equals("impossible"));
	    	assertFalse(c.equals(c2)); //revise
	    	c2.setLevel(level);
	    	
	    	assertTrue(c.equals(c2));
	    	assertTrue(c.hashCode()==c2.hashCode());	    	
	}
	
	@Test
	public void teacherTest() {
		String name = "aaa";
		int id = 0;
		Teacher t1 = new Teacher(id,name);
		Teacher t2 = new Teacher(id, name);
		
		assertTrue(t1.equals(t2));
		assertTrue(t1.hashCode()==t2.hashCode());
		assertFalse(t1.equals(null));
		assertFalse(t1.equals(1));
		
		t2.setId(1);
		t2.setName("bbb");
		assertFalse(t2.equals(t1));
		assertFalse(t2.hashCode()==t1.hashCode());
	}
	
	@Test
	public void courseDaoTest() {
		
		CourseDAO daoCourse = new CourseDAO();
		/*
		List<Course> l0 = daoCourse.selectActives();
		Course newCourse = new Course("title", "level", true, 1, 0);
		daoCourse.insert(newCourse);
		List<Course> l1 = daoCourse.selectActives();
		
		l0.add(newCourse);
		for (Course c : l1)
			assertTrue(l0.contains(c));
		
		assertTrue(l0.size()==l1.size());
		*/
		
		
	}
}
