package com.hanzu.DAOImpl;
import com.hanzu.model.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hanzu.DAO.StudentDAO;
import com.hanzu.model.Student;
import org.hibernate.Query;

import java.util.*;





public class StudentDAOImpl implements StudentDAO{
	public static SessionFactory connect() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}
	
	
		
	
	public void insera(String username,String email, String password) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setUsername(username);
		student.setEmail(email);
		student.setPassword(password);
		session.save(student);
		tx.commit();
	}
	
	public void modifica(int studentID, String email) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.load(Student.class, studentID);
		student.setEmail(email);
		session.update(student);
		tx.commit();
	}
	
	
	public void delete(int studentID) {
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
	public Student getStudent(String username) {
		Session session = connect().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Student.class);
		Student student = (Student)cr.add(Restrictions.eq("username", username)).uniqueResult();
		
		return student;
	}
	public List<Student> afisarecurs(){
		List<Student> studentList = null;
		Cursuri curs = new Cursuri();
		
		Session session = connect().openSession();
		session.beginTransaction();
		
		String hql = "select s.username, c.denumire from Student s JOIN s.cursuri c WHERE c.studentID = :IDcategory";
		Query query = session.createQuery(hql);
		query.setParameter("IDcategory", curs.getCursID());
		studentList = query.list();
		System.out.println(studentList.size());
		if(studentList!=null) {System.out.println("find");}
		return studentList;
		
	}
	
}

