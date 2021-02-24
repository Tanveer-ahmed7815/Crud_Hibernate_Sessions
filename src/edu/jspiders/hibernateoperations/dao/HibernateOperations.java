package edu.jspiders.hibernateoperations.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import edu.jspiders.hibernateoperations.dto.Movies;
import edu.jspiders.singletonfactory.Singleton;

public class HibernateOperations 
{
	public void insert(Movies movie)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.save(movie);
		
		Transaction tx = session.beginTransaction();
		tx.commit();
		
		System.out.println("Insert Successful");
		
		session.close();
		factory.close();
	}
	
	public Movies getMovieById(int id)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		Movies movie = session.get(Movies.class, id);
		
		
		session.close();
		factory.close();
		
		return movie;
		
		
	}
	
	public void update(int id)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		Movies movie = session.get(Movies.class, id);
		
		if(movie != null)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Movie name 2. Rating 3. Lead Role");
			int ch = sc.nextInt();
			if(ch == 1)
			{
				System.out.println("Enter new movie name");
				String newName = sc.next();
				movie.setName(newName);
			}
			else if(ch == 2)
			{
				System.out.println("Enter new rating");
				double newRating = sc.nextDouble();
				movie.setRating(newRating);
			}
			else if (ch == 3)
			{
				System.out.println("Enter new lead role");
				String newLeadRole = sc.next();
				movie.setLeadRole(newLeadRole);
			}
			session.update(movie);
			
			Transaction tx = session.beginTransaction();
			tx.commit();
			
			System.out.println("Update Successful");
			
		}
		else
		{
			System.out.println("Data is not present for id = "+id);
		}
	}
	
	public void delete(int id)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		Movies movie = session.get(Movies.class, id);
		
		if(movie != null)
		{
			session.delete(movie);
			Transaction tx = session.beginTransaction();
			tx.commit();
			
			System.out.println("Delete Success");
		}
		else
		{
			System.out.println("Data is not present for id = "+id);
		}
	}
}
