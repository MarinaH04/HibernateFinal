package com.hanzu.student;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.*;





public class StudentDAOImpl {
	public static SessionFactory connect() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}
	
	
		
	
	public static void insera(String username,String email, String password) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setUsername(username);
		student.setEmail(email);
		student.setPassword(password);
		session.save(student);
		tx.commit();
	}
	
	public static void modifica(int studentID, String email) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.load(Student.class, studentID);
		student.setEmail(email);
		session.update(student);
		tx.commit();
	}
	
	
	public static void delete(int studentID) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.load(Student.class, studentID);
		session.delete(student);
		tx.commit();
	}

	public List<Student> displayStudents(){
		List<Student> studentList = null;
		Session session = connect().openSession();
		session.beginTransaction();
		studentList = (List<Student>) session.createCriteria(Student.class).list();
		return studentList;
	}
	
}

