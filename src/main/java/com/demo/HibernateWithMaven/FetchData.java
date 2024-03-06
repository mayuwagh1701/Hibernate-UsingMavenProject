package com.demo.HibernateWithMaven;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
	 public static void main(String[] args) {
		Configuration cf = new Configuration();
		cf.configure().addAnnotatedClass(Books.class);
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		
//		Books books = session.get(Books.class, 5);
//		System.out.println(books);
		
		//List<Books> list = session.createCriteria(Books.class).list();
		
		List<Books> list = session.createQuery("from Books").list();
		for(Books bb : list) {
			System.out.println(bb.getBid());
			System.out.println(bb.getBname());
			
			System.out.println("**********************");
		}
	}

}
