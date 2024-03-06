package com.demo.HibernateWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
	
	public static void main(String[] args) {
		Configuration cf = new Configuration();
		cf.configure().addAnnotatedClass(Books.class);
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		Books books = session.get(Books.class, 4);
		session.delete(books);
		t.commit();
		sf.close();
		System.out.println("Data Deleted");
	}

}
