package com.hanzu.DAOImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hanzu.DAO.CursuriDAO;
import com.hanzu.model.Cursuri;
import com.hanzu.model.Student;





public class CursuriDAOImpl implements CursuriDAO {
	public static SessionFactory connect1() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cursuri.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}
	
	public List<Cursuri> displayCursuri(){
		List<Cursuri> cursuriList = new ArrayList<Cursuri>();
		Session session = connect1().openSession();
		session.beginTransaction();
		cursuriList = (List<Cursuri>) session.createCriteria(Cursuri.class).list();
		return cursuriList;
	}
		
	
	public void insera(int cursID,String nume, List<Student> student) {
		Session session = connect1().openSession();
		Transaction tx = session.beginTransaction();
		Cursuri curs = new Cursuri();
		curs.setCursID(cursID);
		curs.setDenumire(nume);
		curs.setStudent(student);
		session.save(curs);
		tx.commit();
		session.close();
	}
	
	public void modifica(int idcurs, String numecurs) {
		Session session = connect1().openSession();
		Transaction tx = session.beginTransaction();
		Cursuri curs = (Cursuri) session.load(Cursuri.class, idcurs);
		curs.setDenumire(numecurs);
		session.update(curs);
		tx.commit();
	}
	
	
	public void delete(int idcurs) {
		Session session = connect1().openSession();
		Transaction tx = session.beginTransaction();
		Cursuri curs = (Cursuri) session.load(Cursuri.class, idcurs);
		session.delete(curs);
		tx.commit();
	}
	
	

	
}

