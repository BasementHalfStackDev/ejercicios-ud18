package ejercicio_5;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_5_App {

	public static void main(String[] args) {

		// Create connection
		Connection conexion = Java_SQL.conectarDB();

		// Create DB
		Java_SQL.createDB("UD18_EJ5", conexion);

		// Create Tables
		Java_SQL.createTable(conexion, "UD18_EJ5", "despachos", "(numero INT PRIMARY KEY, capacidad INT NOT NULL)");
		Java_SQL.createTable(conexion, "UD18_EJ5", "directores",
				"(DNI VARCHAR(9) PRIMARY KEY, nombre VARCHAR(255) NOT NULL, DNI_jefe VARCHAR(9), despacho INT NOT NULL, "
						+ "FOREIGN KEY (DNI_Jefe) REFERENCES directores(DNI), "
						+ "FOREIGN KEY (despacho) REFERENCES despachos(numero))");

		// Add values
		Java_SQL.insertData(conexion, "UD18_EJ5", "despachos",
				"(numero, capacidad) VALUES (1, 5), (2, 10), (3, 20), (4, 1), (5, 5)");
		Java_SQL.insertData(conexion, "UD18_EJ5", "directores",
				"(DNI, nombre, DNI_jefe, despacho) VALUES " 
						+ "('12345678A', 'Jose Marin', NULL, 4),"
						+ "('77791527F', 'Josep Maria Pallas', '12345678A', 1),"
						+ "('12345678B', 'Joan Lapeyra', '12345678A', 1),"
						+ "('12345678C', 'Marta Cyrn', '77791527F', 2),"
						+ "('12345678D', 'Sergi Gimenez', NULL, 3)");

		// Close connection
		Java_SQL.closeConnection(conexion);

	}

}
