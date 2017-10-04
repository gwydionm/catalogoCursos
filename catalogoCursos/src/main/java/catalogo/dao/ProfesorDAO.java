package catalogo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import catalogo.modelo.Profesor;

public class ProfesorDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public ProfesorDAO(){
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	
	public List<Profesor> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Profesor> list = session.selectList("Profesor.selectAll");
			return list;
		} finally {
			session.close();
		}
	}
}
