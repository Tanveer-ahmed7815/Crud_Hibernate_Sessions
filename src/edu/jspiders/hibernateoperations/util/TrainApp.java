package edu.jspiders.hibernateoperations.util;

import java.util.Scanner;

import edu.jspiders.hibernateoperations.dao.TrainsOperations;

import edu.jspiders.hibernateoperations.dto.Trains;

public class TrainApp 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Insert 2.Get by Id 3.Update 4.Delete");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		
		TrainsOperations op = new TrainsOperations();
		
		if(choice==1)
		{
			Trains train = new Trains();
			
			/*System.out.println("Enter movie id");
			int movieId = sc.nextInt();
			movie.setMovieId((movieId));*/
			
			System.out.println("Enter train name");
			String name = sc.next();
			train.setName(name);
			
			System.out.println("Enter source station");
			String sourceStation = sc.next();
			train.setSourceStation((sourceStation));
			
			System.out.println("Enter destination station");
			String destinationStation = sc.next();
			train.setDestinationStation((destinationStation));
			
			System.out.println("Enter departure time");
			String departureTime = sc.next();
			train.setDepartureTime((departureTime));
			
			System.out.println("Enter arrival time");
			String arrivalTime = sc.next();
			train.setArrivalTime((arrivalTime));
			
			
			op.insert(train);
			
			
		}
		else if(choice == 2)
		{
			System.out.println("Enter Train Id");
			int id = sc.nextInt();
			Trains train = op.getTrainById(id);
			
			if(train != null)
			{
				System.out.println(train);
			}
			else
			{
				System.out.println("Data with given id " +id+ "is not present");
			}
		}
		else if(choice == 3)
		{
			System.out.println("Enter Train Id");
			int id = sc.nextInt();
			op.update(id);
		}
		else if(choice == 4)
		{
			System.out.println("Enter Train Id");
			int id = sc.nextInt();
			op.delete(id);
		}
	}
}
