package gerCursos.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	private Double value;
	private Date date;
	private String description;
	
	public Transaction() {
	}
	
	public Transaction(double value, String description, Date date) {
		this.value = value;
		this.description = description;
		this.date = date;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}
		
	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "\nvalor = " + value + ", "
				+ "data = " + sdf.format(date) + ", "
				+ "descrição = " + description ;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public String getDate(Date inputDate) {
		return sdf.format(inputDate);
	}

	
}
