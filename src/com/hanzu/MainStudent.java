package com.hanzu;

import java.util.*;

import org.hibernate.Session;


import com.hanzu.DAOImpl.StudentDAOImpl;
import com.hanzu.model.Student;
import com.mysql.cj.Query;

public class MainStudent {
	public static void main(String[] args) {
		StudentDAOImpl studentDAO = new StudentDAOImpl();
//		studentDAO.insera("Larisa", "lari@yahoo.com", "lari1234");
//		studentDAO.modifica(30, "razvan@yahoo.com");
//		studentDAO.delete(34);
//	StudentDAOImpl display = new StudentDAOImpl();
//	List<Student> stud = display.displayStudents();
//
//	if(stud !=null && stud.size() > 0) {
//		for(Student student : stud) {
//			System.out.println(student.toString());
//		}
//	}
//	else {
//		System.out.println("No students");
//	}
	
		System.out.println(studentDAO.getStudent("Mihaela"));
		StudentDAOImpl display = new StudentDAOImpl();
		List<Student> studenti = display.afisarecurs();
		if(studenti!=null && studenti.size() > 0) {
			System.out.println("da");
			for(Student student: studenti) {
			System.out.println(student.toString());}
		}
		
     		}
	
}
