package com.hanzu.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name="student", catalog="student_database", uniqueConstraints = {
		@UniqueConstraint(columnNames = "USERNAME"),
		@UniqueConstraint(columnNames = "EMAIL"),
		@UniqueConstraint(columnNames = "PASSWORD")
})


public class Student implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer studentID;
	private String username;
	private String email;
	private String password;
	private List<Cursuri> cursuri = new ArrayList<Cursuri>();
	
	public Student() {}
	
	public Student(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Student(String username, String email, String password, List<Cursuri> cursuri) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.cursuri = cursuri;
		
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="studentID", unique = true, nullable = false)
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	@Column(name="USERNAME", unique = true, nullable = false, length = 15)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="EMAIL", unique = true, nullable = false, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="PASSWORD", unique = true, nullable = false, length = 30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "studcurs", catalog = "student_database", joinColumns = { 
			@JoinColumn(name = "studID", nullable = false, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "cursuriID", 
					nullable = false, updatable = true) })
	
	public List<Cursuri> getCursuri() {
		return cursuri;
	}

	public void setCursuri(List<Cursuri> cursuri) {
		this.cursuri = cursuri;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", username=" + username + ", email=" + email + ", password="
				+ password + ", cursuri=" + cursuri + "]";
	}

	
	
}
