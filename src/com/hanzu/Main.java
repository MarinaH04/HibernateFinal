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
//		StudentDAOImpl student = new StudentDAOImpl();
//		List<Cursuri> cursuri= new ArrayList(); 
//		student.insera("Cristina", "cricri@yahoo.com", "789555", cursuri);
//		student.delete(4);
		
//		List<Object> result = session.createQuery("FROM Student").list();
//		if(result!=null) {
//			for(Object obj: result) {
//				System.out.println(obj.toString());
//			}
//			
//		}
//		else {
//			System.out.println("No result");
//		}
		
//		Transaction tx = session.beginTransaction();
//		Student student = new Student();
//		System.out.println(student);
//		student.setUsername("Marina");
//		student.setEmail("marina@yahoo.com");
//		student.setPassword("1234");
//		List<Cursuri> li = session.createQuery("FROM Cursuri").list();
////		System.out.println(li.get(0));
////		Cursuri curs = li.get(0);
////		List<Cursuri> m = new ArrayList();
////		System.out.println(curs);
//		student.setCursuri(li);
//		session.save(student);
//		tx.commit();
		
		CursuriDAOImpl cursuri = new CursuriDAOImpl();
		cursuri.delete(1);
		
			
	}
	
}

