package catalog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import catalog.model.Course;

public class CourseDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public CourseDAO(){
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	
	public List<Course> selectActives(){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Course> list = session.selectList("Course.selectActives");
			return list;
		} finally {
			session.close();
		}
	}

	public void insert(Course curso){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Course.insert", curso);
			session.commit();
		} finally {
			session.close();
		}
	}
}
