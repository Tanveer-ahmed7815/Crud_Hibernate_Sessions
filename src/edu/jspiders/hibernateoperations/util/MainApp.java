package edu.jspiders.hibernateoperations.util;

import java.util.Scanner;

import edu.jspiders.hibernateoperations.dao.HibernateOperations;
import edu.jspiders.hibernateoperations.dto.Movies;

public class MainApp 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Insert 2.Get by Id 3.Update 4.Delete");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		
		HibernateOperations op = new HibernateOperations();
		
		if(choice==1)
		{
			Movies movie = new Movies();
			
			/*System.out.println("Enter movie id");
			int movieId = sc.nextInt();
			movie.setMovieId((movieId));*/
			
			System.out.println("Enter movie name");
			String name = sc.next();
			movie.setName(name);
			
			System.out.println("Enter movie rating");
			double rating = sc.nextDouble();
			movie.setRating((rating));
			
			System.out.println("Enter lead role");
			String leadRole = sc.next();
			movie.setLeadRole(leadRole);
			
			op.insert(movie);
			
			
		}
		else if(choice == 2)
		{
			System.out.println("Enter Movie Id");
			int id = sc.nextInt();
			Movies movie = op.getMovieById(id);
			
			if(movie != null)
			{
				System.out.println(movie);
			}
			else
			{
				System.out.println("Data with given id "+id+ "is not present");
			}
		}
		else if(choice == 3)
		{
			System.out.println("Enter Movie Id");
			int id = sc.nextInt();
			op.update(id);
		}
		else if(choice == 4)
		{
			System.out.println("Enter Movie Id");
			int id = sc.nextInt();
			op.delete(id);
		}
	}
}
