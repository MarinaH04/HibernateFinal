package com.hanzu.DAO;

import java.util.List;

import com.hanzu.model.Student;

public interface StudentDAO {
	public void insera(String username,String email, String password);
	public void modifica(int studentID, String email);
	public void delete(int studentID);
	public List<Student> displayStudents();
}
