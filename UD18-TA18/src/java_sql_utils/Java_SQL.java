package java_sql_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class Java_SQL {
	
	public static Connection conectarDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.177:3306","java","Java_R00t");
			System.out.println("Connected");
			return conexion;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection couldn't be established");
			System.out.println(e);
		}
		return null;
	}
	
	public static void closeConnection(Connection conexion) {
		try {
			conexion.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.out.println("Connection couldn't be closed");
			System.out.println(e);
		}
	}

}
