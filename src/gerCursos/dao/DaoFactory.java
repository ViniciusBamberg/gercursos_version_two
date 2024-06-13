package gerCursos.dao;

import db.DB;
import gerCursos.dao.impl.CourseDaoJDBC;
import gerCursos.dao.impl.StudentDaoJDBC;

public class DaoFactory {

	public static StudentDao createStudentDao() {
		return new StudentDaoJDBC(DB.getConnection());
	}
	
	public static CourseDao createCourseDao() {
		return new CourseDaoJDBC(DB.getConnection());
	}
}
