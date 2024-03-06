package com.demo.HibernateWithMaven;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration cf = new Configuration();
		cf.configure();
		cf.addAnnotatedClass(Books.class);
		SessionFactory sf = cf.buildSessionFactory();

		Session session = sf.openSession();
		

		Transaction t = session.beginTransaction();
		Books b1 = new Books(1, "Human Power ");
		Books b2 = new Books(2, "Machine Learning ");
		Books b3 = new Books(3, "The Secret ");
		Books b4 = new Books(4, "The World ");
		Books b5 = new Books(5, "Programing Login ");
		ArrayList<Books> bb = new ArrayList<Books>();
		bb.add(b1);
		bb.add(b2);
		bb.add(b3);
		bb.add(b4);
		bb.add(b5);

		for (Books books : bb) {
			session.save(books);
		}
		
		t.commit();
		sf.close();
		System.out.println("data inserted");

	}
}
