package catalog.integrity;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import catalog.dao.CourseDAO;
import catalog.dao.CourseMapper;
import catalog.model.Course;
import catalog.model.Level;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
@Transactional
public class CursoDAOIntegTest {

	@Resource
	CourseMapper cursoMapper;

	CourseDAO dao;
	
	@Before
	public void init() {
		dao = new CourseDAO();		
	}
	
	@Test
	public void sessionNotNull() {
		assertNotNull(dao.getSession());
	}
	
	@Test
	public void querys() {
		List<Course> list = dao.selectActives();
		Course c = new Course(list.size(), "title", Level.ADVANCED.toString(), 1, 25, list.get(0).getTeacherID(), "");
		dao.insert(c);
		List<Course> list2 = dao.selectActives();
		
		assertTrue(list.size()+1==list2.size());
		dao.deleteID(c.getId());
		assertTrue(dao.selectActives().size()==list.size());
		
		Course c2 = new Course(list2.size(), "title2", Level.ADVANCED.toString(), 0, 25, list.get(0).getTeacherID(), "");
		dao.insert(c2);
		assertFalse(dao.selectActives().size() == list2.size()+1);
		dao.deleteID(c2.getId());
		assertTrue(dao.selectActives().size()==list.size());
	}

}