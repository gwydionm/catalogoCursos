package catalogo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import catalogo.modelo.Curso;

public class CursoDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public CursoDAO(){
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	
	public List<Curso> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Curso> list = session.selectList("Curso.selectAll");
			return list;
		} finally {
			session.close();
		}
	}

	public void insert(Curso curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Curso.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}
}
