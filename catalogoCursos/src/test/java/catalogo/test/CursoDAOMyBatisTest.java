package catalogo.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import catalogo.dao.CursoMapper;
import catalogo.modelo.Curso;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/application-context.xml" })
@Transactional
public class CursoDAOMyBatisTest {

	@Resource
	CursoMapper cursoMapper;

	@Test
	public void crudCurso() {

		int sizeInitial = cursoMapper.selectAll().size();

		Curso curso = new Curso();
		curso.setActivo("SI");
		curso.setHoras(250);
		curso.setId(sizeInitial+1);
		curso.setNivel("Avanzado");
		curso.setIdProfesor(1);
		curso.setTitulo("Mi curso num4");

		cursoMapper.insert(curso);

		assertEquals(sizeInitial + 1, cursoMapper.selectAll().size());

	}

}