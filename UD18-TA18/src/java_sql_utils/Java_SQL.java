package java_sql_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Java_SQL {
	
	public static void conectarDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.177:3306","java","Java_R00t");
			System.out.println("Connected");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection couldn't be established");
			System.out.println(e);
		}
	}
	
	

}
