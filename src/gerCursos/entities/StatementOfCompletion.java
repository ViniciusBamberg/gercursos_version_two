package gerCursos.entities;

import java.util.Date;

public class StatementOfCompletion {
	private String studentName;
	private String course;
	private Date conclusionDate;

	public StatementOfCompletion(String studentName, String course, Date conclusionDate) {
	        this.studentName = studentName;
	        this.course = course;
	        this.conclusionDate = conclusionDate;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getConclusionDate() {
		return conclusionDate;
	}

	public void setConclusionDate(Date conclusionDate) {
		this.conclusionDate = conclusionDate;
	}
}
