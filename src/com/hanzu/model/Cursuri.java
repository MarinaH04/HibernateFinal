package com.hanzu.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="cursuri", catalog = "student_database")
public class Cursuri implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cursID;
	private String denumire;
	private List<Student> student = new ArrayList<Student>();

	public Cursuri() {}
	
	public Cursuri(String denumire) {
		this.denumire = denumire;
	}
	public Cursuri(String denumire, List<Student> student) {
		this.denumire = denumire;
		this.student = student;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="cursID", unique = true, nullable = false)
	public Integer getCursID() {
		return cursID;
	}

	public void setCursID(Integer cursID) {
		this.cursID = cursID;
	}
	
	@Column(name="denumire", unique = true, nullable = false, length = 20)
	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "cursuri", cascade = CascadeType.ALL)
	public List<Student> getStudent() {
		return student;
	}

	

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Cursuri [cursID=" + cursID + ", denumire=" + denumire + "]";
	}
	
}
