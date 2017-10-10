package catalog.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import catalog.model.Course;

public class CourseDAO implements Serializable {
	
	private static final long serialVersionUID = -3232542606308469027L;
	
	private transient SqlSessionFactory sqlSessionFactory; 
	
	public CourseDAO(){
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	public List<Course> selectActives(){

		SqlSession session = getSession();
		
		try {
			return session.selectList("Course.selectActives");
		} finally {
			session.close();
		}
	}

	public void insert(Course course){

		SqlSession session = getSession();
		
		try {
			session.insert("Course.insert", course);
			session.commit();
		} finally {
			session.close();
		}
	}
}