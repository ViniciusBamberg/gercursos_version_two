package gerCursos.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String teacher;
	private String description;
	private Date start;
	private Date end;
	private Integer studentsQuantity;
	private Double courseValue;
	private Double registrationValue;
	private String status;
	private List<Student> students;
	 
	public Finance finance;
	public Transaction transaction;
	
	public Course() {
	}
	
	public Course(Integer id, String name, String teacher, String description, Date start, Date end,
			Integer studentsQuantity, Double courseValue, Double registrationValue, String status) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.description = description;
		this.start = start;
		this.end = end;
		this.studentsQuantity = studentsQuantity;
		this.courseValue = courseValue;
		this.registrationValue = registrationValue;
		this.status = status;
		this.students = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeacher() {
		return teacher;
	}
	
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	public Integer getStudentsQuantity() {
		return studentsQuantity;
	}
	
	public void setStudentsQuantity(Integer studentsQuantity) {
		this.studentsQuantity = studentsQuantity;
	}
	
	public Double getCourseValue() {
		return courseValue;
	}
	
	public void setCourseValue(Double courseValue) {
		this.courseValue = courseValue;
	}
	
	public Double getRegistrationValue() {
		return registrationValue;
	}
	
	public void setRegistrationValue(Double registrationValue) {
		this.registrationValue = registrationValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
        this.students.add(student);
	}
	
	public void removeStudentById(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(end, id, name, start, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(end, other.end) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(start, other.start) && Objects.equals(teacher, other.teacher);
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public String toString() {
		return "Índice = " + id + ", "
				+ "Nome = " + name + ", "
				+ "Professor = " + teacher + ", "
				+ "Descrição = " + description + ", "
				+ "Início = " + sdf.format(start) + ", "
				+ "Fim = " + sdf.format(end) + ", "
				+ "Quantidade de estudantes = " + studentsQuantity + ", "
				+ "Valor do curso = " + courseValue + ", "
				+ "Valor da matrícula = " + registrationValue + ", "
				+ "Situação = " + status ;
	}
}
