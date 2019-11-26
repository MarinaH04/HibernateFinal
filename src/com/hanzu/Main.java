package com.hanzu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hanzu.DAOImpl.CursuriDAOImpl;
import com.hanzu.DAOImpl.StudentDAOImpl;
import com.hanzu.model.Cursuri;
import com.hanzu.model.Student;


public class Main {
	public static SessionFactory connect() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}


	public static void main(String[] args) {
		Session session = connect().openSession();
		StudentDAOImpl student = new StudentDAOImpl();
		student.displayStudents();
//		List<Cursuri> cursuri= new ArrayList(); 
//		student.insera("Alina", "alinutza@yahoo.com", "55789", cursuri);
//		student.delete(3);
		

		
//		CursuriDAOImpl cursuri = new CursuriDAOImpl();
//		cursuri.delete(1);
		
			
	}
	
}

