package catalog.unitary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import catalog.dao.CourseDAO;
import catalog.dao.TeacherDAO;
import catalog.model.Course;
import catalog.model.Level;
import catalog.model.Teacher;
import catalog.view.MainController;

public class MainControllerTest {

	private MainController empty, controller;
	private CourseDAO daoCourseMock;
	private TeacherDAO daoTeacherMock;
	
	List<Course> courses;
	List<Teacher> teachers;
	List<String> gotten;
	List<String> names;
	List<String> levels;
	
	@Before
	public void initTest() {
		courses =  new ArrayList<Course>();
		courses.add(new Course(1, "a", "Basic", 1, 25, 1));
		courses.add(new Course(2, "b", "Basic", 1, 25, 1));
		courses.add(new Course(3, "c", "Basic", 1, 25, 1));
		
		teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher(1,"juan"));
		teachers.add(new Teacher(2,"luis"));
		
		names = new ArrayList<String>();
		names.add("juan");
		names.add("luis");   	

		levels = new ArrayList<String>();
		for (Level l : Level.values())
			levels.add(l.toString());
		
	    empty = new MainController();
	    
	    	daoCourseMock = mock(CourseDAO.class); 
	    	when(daoCourseMock.selectActives()).thenReturn(courses);
	    	daoTeacherMock = mock(TeacherDAO.class);
	    	when(daoTeacherMock.selectAll()).thenReturn(teachers);
	
	    //	controller = new MainController(daoCourseMock, daoTeacherMock);
	}
	
	@Test
	public void emptyControllerTest() {
	    assertNull(empty.getNameOfTeachers());
	    empty.setNameOfTeachers(names);
	
	    gotten = empty.getNameOfTeachers();
	    assertTrue(names.size()==gotten.size());
	    for (int i=0; i<names.size(); i++)
	    		assertTrue(names.get(i).equals(gotten.get(i)));
	}
	
    @Test
    public void normalControllerTest()  {
        assertFalse(controller.isActive());
        controller.setActive(true);
        assertTrue(controller.isActive());
        
        controller.setCourses(null);
        assertNull(controller.getCourses());
        controller.setCourses(courses);
        
        controller.setTeachers(null);
        assertNull(controller.getTeachers());
        controller.setTeachers(teachers);
        
        assertTrue(controller.getHours()==0);
        controller.setHours(25);
        assertTrue(controller.getHours()==25);

        assertTrue(controller.getLevel().equals(""));
        controller.setLevel("lelele");
        assertTrue(controller.getLevel().equals("lelele"));
        
        assertTrue(controller.getTeacher().equals(""));
        controller.setTeacher("tetete");
        assertTrue(controller.getTeacher().equals("tetete"));
        
        assertTrue(controller.getTitle().equals(""));
        controller.setTitle("tititi");
        assertTrue(controller.getTitle().equals("tititi"));
        
        controller.setLevels(null);
        assertNull(controller.getLevels());
        controller.setLevels(levels);
        gotten = controller.getLevels();
        assertTrue(levels.size()==gotten.size());
        for (int i=0; i<levels.size(); i++)
        		assertTrue(levels.get(i).equals(gotten.get(i)));
        
        
    }
    
    @Test
    public void newCourseTest() {
        controller.setActive(true);
        controller.newCourse();
        verify(daoCourseMock).insert(any(Course.class));
        controller.setActive(false);
        controller.newCourse();
        verify(daoCourseMock, times(2)).insert(any(Course.class));
    }
	
}
