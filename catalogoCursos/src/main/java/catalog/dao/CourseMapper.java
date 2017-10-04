package catalog.dao;

import java.util.List;

import catalog.model.Course;

public interface CourseMapper {

	List<Course> selectActives();
	
	void insert(Course curso);
	
}
