package gerCursos.dao;

import java.util.List;

import gerCursos.entities.Course;
import gerCursos.entities.Student;

public interface CourseDao {

	void insert(Course course);
	void update(Course course);
	void deleteById(Integer id);
	Course findById(Integer id);
	List<Course> findAll();
	void associationCourseDao(Course course);
	void removeStudentFromCourse(int courseId, int studentId);
	List<Student> findByCourse(Course course);
}
