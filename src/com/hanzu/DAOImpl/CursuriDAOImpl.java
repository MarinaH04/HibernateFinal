package com.hanzu.DAOImpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hanzu.DAO.CursuriDAO;
import com.hanzu.model.Cursuri;





public class CursuriDAOImpl implements CursuriDAO {
	public static SessionFactory connect() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cursuri.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf;
	}
	
	
		
	
	public void insera(int cursID,String nume) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Cursuri curs = new Cursuri();
		curs.setCursID(cursID);
		curs.setDenumire(nume);
		session.save(curs);
		tx.commit();
	}
	
	public void modifica(int idcurs, String numecurs) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Cursuri curs = (Cursuri) session.load(Cursuri.class, idcurs);
		curs.setDenumire(numecurs);
		session.update(curs);
		tx.commit();
	}
	
	
	public void delete(int idcurs) {
		Session session = connect().openSession();
		Transaction tx = session.beginTransaction();
		Cursuri curs = (Cursuri) session.load(Cursuri.class, idcurs);
		session.delete(curs);
		tx.commit();
	}
	
	

	
}

