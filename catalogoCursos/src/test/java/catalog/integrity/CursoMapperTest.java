package catalog.integrity;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import catalog.dao.CourseMapper;
import catalog.model.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
@Transactional
public class CursoMapperTest {

	@Resource
	CourseMapper cursoMapper;

	@Test
	public void testCurso() {
		int sizeInitial = cursoMapper.selectActives().size();
		Course c = new Course(4, "Mi curso num4","Avanzado", 1, 250, 1);
		cursoMapper.insert(c);
		assertEquals(sizeInitial + 1, cursoMapper.selectActives().size());
	}

}