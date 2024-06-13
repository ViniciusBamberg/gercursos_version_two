package gerCursos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Finance implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer index;
	private String name;
	private Date date;
	private Double income;
	private Double expense;
	
	private String student;

	private String dateActual;

	private String course;

	private String description;
	
	public Finance() {
	}

	public Finance(Integer index, String name, Date date, Double income, Double expense) {
		super();
		this.index = index;
		this.name = name;
		this.date = date;
		this.income = income;
		this.expense = expense;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public String getStudent() {
		return student;
	}
	
	public void setStudent(String student) {
		this.student = student;	
	}

	public String getDateActual() {
		return dateActual;
	}

	public void setDateActual(String dateActual) {
		this.dateActual = dateActual;		
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;		
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, index, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Finance other = (Finance) obj;
		return Objects.equals(date, other.date) && Objects.equals(index, other.index)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "index = " + index + ", nome = " + name + ", data = " + date + ", descrição = " + description;
	}



}
