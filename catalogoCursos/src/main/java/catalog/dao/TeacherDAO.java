package catalog.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import catalog.model.Teacher;
import catalog.dao.ConnectionFactory;

public class TeacherDAO implements Serializable {
	
	private static final long serialVersionUID = -3215562265614713977L;
	
	private transient SqlSessionFactory sqlSessionFactory; 
	
	public TeacherDAO(){
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	
	public List<Teacher> selectAll(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.selectList("Teacher.selectAll");
		} finally {
			session.close();
		}
	}
}
