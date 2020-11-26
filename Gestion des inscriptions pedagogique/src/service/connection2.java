package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection2 {

	public static Statement sqlStatement() {
		
		try  {
			System.out.println("adding driver  PostgreSQL database!");

	         String dbDriver = "org.postgresql.Driver";
	         Class.forName(dbDriver);
			System.out.println("Connecting to PostgreSQL database!");

			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ministere","postgres", "riad");
			System.out.println("Connected to PostgreSQL database!");
			return connection.createStatement();
			
		} catch (Exception e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
		return null;
	}

}