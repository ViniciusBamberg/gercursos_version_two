package gerCursos.dao;

import java.util.List;

import gerCursos.entities.Student;

public interface StudentDao {

	void insert(Student student);
	void update(Student student);
	void deleteById(Integer id);
	Student findById(Integer id);
	List<Student> findAll();
}
