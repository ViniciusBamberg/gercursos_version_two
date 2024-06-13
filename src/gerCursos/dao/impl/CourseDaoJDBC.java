package gerCursos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import gerCursos.dao.CourseDao;
import gerCursos.entities.Course;
import gerCursos.entities.Student;

public class CourseDaoJDBC implements CourseDao {

	private Connection conn;
	
	public CourseDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Course course) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("INSERT INTO course ");
			query.append("(Name, Teacher, Description, Start, End, StudentsQuantity, CourseValue, RegistrationValue, Status) ");
			query.append("VALUES(?,?,?,?,?,?,?,?,?) ");
			
			st = conn.prepareStatement(query.toString());
					
			st.setString(1, course.getName());
			st.setString(2, course.getTeacher());
			st.setString(3, course.getDescription());
			st.setDate(4, new java.sql.Date(course.getStart().getTime()));
			st.setDate(5, new java.sql.Date(course.getEnd().getTime()));
			st.setInt(6, course.getStudentsQuantity());
			st.setDouble(7, course.getCourseValue());
			st.setDouble(8, course.getRegistrationValue());
			st.setString(9, course.getStatus());
			st.executeUpdate();
					
		}
		catch(SQLException e) {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Course course) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("UPDATE course ");
			query.append("SET Name=?, Teacher=?, Description=?, Start=?, End=?, ");
			query.append("StudentsQuantity=?, CourseValue=?, RegistrationValue=?, Status=? ");
			query.append("WHERE Id=? ");
			
			st = conn.prepareStatement(query.toString());
	
			st.setString(1, course.getName());
			st.setString(2, course.getTeacher());
			st.setString(3, course.getDescription());
			st.setDate(4, new java.sql.Date(course.getStart().getTime()));
			st.setDate(5, new java.sql.Date(course.getEnd().getTime()));
			st.setInt(6, course.getStudentsQuantity());
			st.setDouble(7, course.getCourseValue());
			st.setDouble(8, course.getRegistrationValue());
			st.setString(9, course.getStatus());
			st.setInt(10, course.getId());
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("DELETE FROM course ");
			query.append("WHERE Id=? ");
			
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Course findById(Integer id) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("SELECT * FROM course ");
			query.append("WHERE course.Id = ?");
			
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Course course = instanciateCourse(rs);
				return course;
			}
			DB.closeResultSet(rs);
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
	
	/*private Student instanciateStudent(ResultSet rs, Course course) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("StudentId"));
		student.setName(rs.getString("StudentName"));
		student.setCpf(rs.getString("StudentCpf"));
		return student;
	}*/

	private Course instanciateCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setId(rs.getInt("Id"));
		course.setName(rs.getString("Name"));
		course.setTeacher(rs.getString("Teacher"));
		course.setDescription(rs.getString("Description"));
		course.setStart(rs.getDate("Start"));
		course.setEnd(rs.getDate("End"));
		course.setStudentsQuantity(rs.getInt("StudentsQuantity"));
		course.setCourseValue(rs.getDouble("CourseValue"));
		course.setRegistrationValue(rs.getDouble("RegistrationValue"));
		return course;
	}

	@Override
	public List<Course> findAll() {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			query.append("SELECT * FROM course");
			
			st = conn.prepareStatement(query.toString());
			
			rs = st.executeQuery();
			
			List<Course> courses = new ArrayList<>();
			
			while (rs.next()) {
				 Integer id = rs.getInt("Id");
				 String name = rs.getString("Name");
	             String teacher = rs.getString("Teacher");
	             String description = rs.getString("Description");
	             Date start = rs.getDate("Start");
	             Date end = rs.getDate("End");
	             Integer studentsQuantity = rs.getInt("StudentsQuantity");
	             Double courseValue = rs.getDouble("CourseValue");
	             Double registrationValue = rs.getDouble("RegistrationValue");
	             String status = rs.getString("Status");	             
	            
	            // System.out.println("Id: " + id + ", Name: " + name);
	            		 		             
	             courses.add(new Course(id, name, teacher, description, start, end, studentsQuantity, courseValue, registrationValue, status));
			}
			return courses;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public void associationCourseDao(Course course) {
				
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("INSERT INTO course_student (fk_course, fk_student) ");
			query.append("VALUES (?, ?) ");
			
			st = conn.prepareStatement(query.toString());
			        
	        int courseId = course.getId();
	        
	        for (Student student : course.getStudents()) {
	            int studentId = student.getId();
	            st.setInt(1, courseId);
	            st.setInt(2, studentId);
	            st.addBatch();
	        }
	        st.executeBatch();
	    }
	    catch(SQLException e) {
	        throw new DbException("Erro ao associar estudante(s) ao curso: " + e.getMessage());
	    }
	    finally {
	        DB.closeStatement(st);
	    }   
	}
	
	public void removeStudentFromCourse(int courseId, int studentId) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("DELETE FROM course_student ");
			query.append("WHERE fk_course=? AND fk_student=? ");
			
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, courseId);
            st.setInt(2, studentId);
            
            st.executeUpdate();
        }
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
    }

	@Override
	public List<Student> findByCourse(Course course) {
			
			StringBuilder query = new StringBuilder();
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				query.append("SELECT st.Id, st.Name FROM course cs ");
		        query.append("JOIN course_student cst ON cst.fk_course = cs.Id ");
		        query.append("JOIN student st ON st.Id = cst.fk_student ");
		        query.append("WHERE cs.Id = ? ");
				
				st = conn.prepareStatement(query.toString());
				
				st.setInt(1, course.getId());
								
				rs = st.executeQuery();
				
				List<Student> list = new ArrayList<>();
							
				int sum = 0;
				System.out.println("Lista de Estudantes: ");
				while(rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("Id"));
					student.setName(rs.getString("Name"));
					list.add(student);
			        System.out.println("Id: " + student.getId() + ", Nome: " + student.getName());
			        sum++;
				}
				System.out.println("\nNúmero de estudantes = " + sum);
				return list;
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
			}
	}
}
