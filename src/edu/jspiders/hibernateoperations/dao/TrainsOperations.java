package edu.jspiders.hibernateoperations.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.jspiders.hibernateoperations.dto.Trains;
import edu.jspiders.singletonfactory.Singleton;

public class TrainsOperations 
{
	public void insert(Trains train)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.save(train);
		
		Transaction tx = session.beginTransaction();
		tx.commit();
		
		System.out.println("Insert Successful");
		
		session.close();
		factory.close();
	}
	
	public Trains getTrainById(int id)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		Trains train= session.get(Trains.class, id);
		
		
		session.close();
		factory.close();
		
		return train;
		
		
	}
	
	public void update(int id)
	{
		/*Configuration config = new Configuration();
		config.configure();
		
		//config.addAnnotatedClass(Movies.class);
		
		SessionFactory factory = config.buildSessionFactory();*/
		
		SessionFactory factory = Singleton.getSessionFactory();
		
		Session session = factory.openSession();
		
		Trains train= session.get(Trains.class, id);
		
		if(train != null)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.train name 2. Source station 3. Destination Station 4. Departure Time 5.Arrival Time");
			int ch = sc.nextInt();
			if(ch == 1)
			{
				System.out.println("Enter new train name");
				String newName = sc.next();
				train.setName(newName);
			}
			else if(ch == 2)
			{
				System.out.println("Enter new source station");
				String newSourceStation = sc.next();
				train.setSourceStation(newSourceStation);
			}
			else if (ch == 3)
			{
				System.out.println("Enter new destination station");
				String newDestinationStation = sc.next();
				train.setDestinationStation(newDestinationStation);
			}
			else if(ch == 4)
			{
				System.out.println("Enter new departure time");
				String newDepartureTime = sc.next();
				train.setDepartureTime(newDepartureTime);
			}
			else if(ch == 5)
			{
				System.out.println("Enter new arrivaltime");
				String newArrivalTime = sc.next();
				train.setArrivalTime(newArrivalTime);
			}
			session.update(train);
			
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
		
		Trains train= session.get(Trains.class, id);
		
		if(train != null)
		{
			session.delete(train);
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
