package catalog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import catalog.model.Teacher;
import catalog.dao.ConnectionFactory;

public class TeacherDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public TeacherDAO(){
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	
	public List<Teacher> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Teacher> list = session.selectList("Teacher.selectAll");
			return list;
		} finally {
			session.close();
		}
	}
}
