package catalog.integrity;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import catalog.dao.TeacherDAO;
import catalog.dao.TeacherMapper;

public class TeacherDAOIntegTest {

	@Resource
	TeacherMapper teacherMapper;

	TeacherDAO dao;
	
	@Before
	public void init() {
		dao = new TeacherDAO();		
	}
	
	@Test
	public void querys() {
		assertNotNull(dao.selectAll());
	}
}
