package Assigment2;

import java.util.Date;

public class Student {
// properties.
	private String first_name;
	private String last_name;
	private int id;
	private Date birth_date;
	private double grade;
	private String email;

// Generate constructors;
	public Student() {
	}

	public Student(String first_name, String last_name, int id, Date birth_date, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
		this.birth_date = birth_date;
		this.email = email;
	}

// Generate setters and getters.
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
