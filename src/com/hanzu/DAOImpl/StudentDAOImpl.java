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

import org.hibernate.Query;

import java.util.*;





public class StudentDAOImpl implements StudentDAO{
	public static SessionFactory connect() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}
	
	
		
	
	public void insera(String username,String email, String password, List<Cursuri> cursuri) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setUsername(username);
		student.setEmail(email);
		student.setPassword(password);
		List<Cursuri> li = session.createQuery("FROM Cursuri").list();
		student.setCursuri(li);
		session.save(student);
		tx.commit();
		session.close();
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

	@SuppressWarnings("unchecked")
	public List<Student> displayStudents(){
		List<Student> studentList = new ArrayList<Student>();
		Session session = connect().openSession();
		session.beginTransaction();
		studentList = (List<Student>) session.createCriteria(Student.class).list();
		System.out.println(studentList.size());
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
		
		Session session = connect().openSession();
		Cursuri curs = new Cursuri();
		
        String hql = "select s FROM Student s JOIN s.cursuri c WHERE c.cursID = :IDcategory";
//       String hql = "select s.studentID, s.username, s.email, s.password FROM Student s";
		Query query = session.createQuery(hql);
		query.setParameter("IDcategory", curs.getCursID());
		studentList = query.list();
		System.out.println(studentList.size());
		if(studentList!=null) {System.out.println("find");}
		return studentList;
		
	}
	
}

