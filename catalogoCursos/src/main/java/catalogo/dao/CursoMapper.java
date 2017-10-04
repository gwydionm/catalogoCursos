package catalogo.dao;

import java.util.List;

import catalogo.modelo.Curso;

public interface CursoMapper {

	List<Curso> selectAll();
	
	void insert(Curso curso);
	
}
