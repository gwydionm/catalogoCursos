package catalog.test;

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
public class CursoDAOMyBatisTest {

	@Resource
	CourseMapper cursoMapper;

	@Test
	public void testCurso() {

		int sizeInitial = cursoMapper.selectActives().size();

		Course course = new Course();
		course.setActive(true);
		course.setHours(250);
		course.setLevel("Avanzado");
		course.setTeacherID(1);
		course.setTitle("Mi curso num4");

		cursoMapper.insert(course);

		assertEquals(sizeInitial + 1, cursoMapper.selectActives().size());

	}

}