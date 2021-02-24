package edu.jspiders.hibernateoperations.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator
{

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException 
	{
		//logic to fetch max value from Primary Column
		int count = 3;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3306/heha11_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dbUrl); 
			
			String sql = "select max(movie_id) from movies_db";
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return count + 3;
	}

}
