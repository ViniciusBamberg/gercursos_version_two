package gerCursos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import gerCursos.dao.StudentDao;
import gerCursos.entities.Student;

public class StudentDaoJDBC implements StudentDao {

	private Connection conn;
	
	public StudentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Student student) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append(" INSERT INTO student ");
			query.append(" (Name, Cpf, Address, Email, Phone, Status)");
			query.append(" VALUES(?,?,?,?,?,?)");
			
			st = conn.prepareStatement(query.toString());
					
			st.setString(1, student.getName());
			st.setString(2, student.getCpf());
			st.setString(3, student.getAddress());
			st.setString(4, student.getEmail());
			st.setString(5, student.getPhone());
			st.setString(6, student.getStatus());
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
	public void update(Student student) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("UPDATE student ");
			query.append("SET Name=?,Cpf=?,Address=?,Email=?,Phone=?,Status=? ");
			query.append("WHERE Id=? ");
		
			st = conn.prepareStatement(query.toString());
	
			st.setString(1, student.getName());
			st.setString(2, student.getCpf());
			st.setString(3, student.getAddress());
			st.setString(4, student.getEmail());
			st.setString(5, student.getPhone());
			st.setString(6, student.getStatus());
			st.setInt(7, student.getId());
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
			query.append("DELETE FROM student ");
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
	public Student findById(Integer id) {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		try {
			query.append("SELECT * FROM student ");
			query.append("WHERE student.Id = ?");
			
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Student student = instanciateStudent(rs);
				return student;
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

	private Student instanciateStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("Id"));
		student.setName(rs.getString("Name"));
		student.setCpf(rs.getString("Cpf"));
		student.setAddress(rs.getString("Address"));
		student.setEmail(rs.getString("Email"));
		student.setPhone(rs.getString("Phone"));
		return student;
	}

	/*private Course instanciateCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setId(rs.getInt("CourseId"));
		course.setName(rs.getString("CourseName"));
		return course;
	}*/

	@Override
	public List<Student> findAll() {
		
		StringBuilder query = new StringBuilder();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			query.append("SELECT * FROM student");
			
			st = conn.prepareStatement(query.toString());
			
			rs = st.executeQuery();
			
			List<Student> students = new ArrayList<Student>();
		
			while (rs.next()) {
				 Integer id = rs.getInt("Id");
				 String name = rs.getString("Name");
	             String cpf = rs.getString("Cpf");
	             String address = rs.getString("Address");
	             String email = rs.getString("Email");
	             String phone = rs.getString("Phone");
	             String status = rs.getString("Status");

	            // System.out.println("Id: " + id
	            //         		 			+ ", Name: " + name);
	            		 		             
	             students.add(new Student(id, name, cpf, address, email, phone, status));
	          
			}
			return students;
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
