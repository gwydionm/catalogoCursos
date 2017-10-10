package catalog.unitary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import catalog.model.Teacher;

public class TeacherTest {
	
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

}
