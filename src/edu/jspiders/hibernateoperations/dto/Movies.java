package edu.jspiders.hibernateoperations.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="movies_db")
public class Movies implements Serializable
{
	@GenericGenerator(name="mygen", strategy="edu.jspiders.hibernateoperations.dao.MyGenerator") //if we want our own increment val
	@GeneratedValue(generator="mygen") //strategy="increment" if we want inc by 1
	@Id
	@Column(name="movie_id")
	private int movieId;
	@Column(name="name")
	private String name;
	@Column(name="rating")
	private double rating;
	@Column(name="lead_role")
	private String leadRole;
	
	
	public Movies(int movieId, String name, double rating, String leadRole) 
	{
		this.movieId = movieId;
		this.name = name;
		this.rating = rating;
		this.leadRole = leadRole;
	}
	public Movies()
	{
		System.out.println("Movies object created");
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getLeadRole() {
		return leadRole;
	}
	public void setLeadRole(String leadRole) {
		this.leadRole = leadRole;
	}
	
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", name=" + name + ", rating=" + rating + ", leadRole=" + leadRole + "]";
	}
	
	
	
	
	
}
