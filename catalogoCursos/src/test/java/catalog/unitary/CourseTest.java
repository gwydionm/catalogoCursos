package catalog.unitary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import catalog.model.Course;

public class CourseTest {
	
	@Test
	public void courseTest() {
		String title = "aaa";
		int teacherID = 1;
		int hours = 25;
		String level = "bbb";
		
	    	Course c = new Course(0, title, level, 1, hours, teacherID, "");
	    	Course c2 = new Course(0, title, level, 1, hours, teacherID, "");
	    	
	    	assertFalse(c.equals(null));
	    	assertFalse(c.equals(1));
	    	
	    	c2.setTitle("abc");
	    	assertTrue(c2.getTitle().equals("abc"));
	    	assertFalse(c.equals(c2));
	    	assertTrue(c.hashCode()!=c2.hashCode());
	    	c2.setTitle(title);
	    	
	    	c2.setActive(0);
	    	assertFalse(c2.isActive()==1);
	    	assertFalse(c.equals(c2));
	    	c2.setActive(1);
	    	
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

}
