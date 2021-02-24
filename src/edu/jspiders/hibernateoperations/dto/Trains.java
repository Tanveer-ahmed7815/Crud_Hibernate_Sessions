package edu.jspiders.hibernateoperations.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="train_db")
public class Trains implements Serializable
{
	@GenericGenerator(name="mygen", strategy="increment")
	@GeneratedValue(generator="mygen")
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="source_station")
	private String sourceStation;
	@Column(name="destination_station")
	private String destinationStation;
	@Column(name="departure_time")
	private String departureTime;
	@Column(name="arrival_time")
	private String arrivalTime;
	
	
	
	public Trains()
	{
		System.out.println("Trains object created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Trains [id=" + id + ", name=" + name + ", sourceStation=" + sourceStation + ", destinationStation="
				+ destinationStation + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	
	
	
	
	
}
