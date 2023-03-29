package ejercicio_7;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_7_App {

	public static void main(String[] args) {

		// Create connection
		Connection conexion = Java_SQL.conectarDB();

		// Create DB
		Java_SQL.createDB("UD18_EJ7", conexion);

		// Create Tables
		Java_SQL.createTable(conexion, "UD18_EJ7", "cientificos",
				"(DNI VARCHAR(9) PRIMARY KEY, nombre VARCHAR(255) NOT NULL)");
		Java_SQL.createTable(conexion, "UD18_EJ7", "proyecto",
				"(numero CHAR(4) PRIMARY KEY, nombre VARCHAR(255) NOT NULL, horas INT NOT NULL)");
		Java_SQL.createTable(conexion, "UD18_EJ7", "asignado_a",
				"(cientifico VARCHAR(9), proyecto CHAR(9), PRIMARY KEY (cientifico, proyecto),"
						+ "FOREIGN KEY (cientifico) REFERENCES cientificos(DNI), "
						+ "FOREIGN KEY (proyecto) REFERENCES proyecto(numero))");

		// Add values
		Java_SQL.insertData(conexion, "UD18_EJ7", "cientificos",
				"(DNI, nombre) VALUES " 
						+ "('12345678A', 'Jose Marin'), " 
						+ "('77791527F', 'Josep Pallas'), "
						+ "('12345678B', 'Joan Lapeyra'), " 
						+ "('12345678C', 'Marta Cyrn'), "
						+ "('12345678D', 'Cientifico Ejemplo')");

		Java_SQL.insertData(conexion, "UD18_EJ7", "proyecto",
				"(numero, nombre, horas) VALUES " 
						+ "('ABC1', 'Bootcamp Java', 350),"
						+ "('ABC2', 'Acelerador de particulas', 2000),"
						+ "('ABC3', 'Diseño base de datos', 20),"
						+ "('ABC4', 'Renovacion hardware', 50)," 
						+ "('ABC5', 'Desarrollo medicamentos', 1000)");
		
		Java_SQL.insertData(conexion, "UD18_EJ7", "asignado_a",
				"(cientifico, proyecto) VALUES " 
						+ "('12345678A', 'ABC1'),"
						+ "('77791527F', 'ABC1'),"
						+ "('12345678B', 'ABC1'),"
						+ "('12345678C', 'ABC2')," 
						+ "('12345678A', 'ABC4')," 
						+ "('12345678D', 'ABC3')");

		// Close connection
		Java_SQL.closeConnection(conexion);

	}

}
