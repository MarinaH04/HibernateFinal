package com.hanzu.student;

import java.util.*;

public class Main {
	public static void main(String[] args) {
//		Operatii.insera("Larisa", "lari@yahoo.com", "lari1234");
//		Operatii.modifica(30, "razvan@yahoo.com");
//		Operatii.delete(34);
		StudentDAOImpl display = new StudentDAOImpl();
		List<Student> stud = display.displayStudents();
	
		if(stud !=null && stud.size() > 0) {
			for(Student student : stud) {
				System.out.println(student.toString());
			}
		}
		else {
			System.out.println("No students");
		}
	}
}
