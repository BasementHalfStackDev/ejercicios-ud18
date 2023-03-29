package ejercicio_3;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_3_App {

	public static void main(String[] args) {

		// Create connection
		Connection conexion = Java_SQL.conectarDB();

		// Create DB
		Java_SQL.createDB("UD18_EJ3", conexion);

		// Create Tables
		Java_SQL.createTable(conexion, "UD18_EJ3", "almacenes",
				"(codigo INT PRIMARY KEY, lugar VARCHAR(100), capacidad INT NOT NULL)");
		Java_SQL.createTable(conexion, "UD18_EJ3", "cajas",
				"(codigo CHAR(5) PRIMARY KEY, contenido VARCHAR(100) NOT NULL, valor INT NOT NULL, "
						+ "almacen INT NOT NULL, FOREIGN KEY (almacen) REFERENCES almacenes(codigo))");

		// Add values
		Java_SQL.insertData(conexion, "UD18_EJ3", "almacenes",
				"(codigo, lugar, capacidad) VALUES (1, 'Barcelona', 500), (2, 'Madrid', 1000), "
						+ "(3, 'Alicante', 250), (4, 'Tarragona', 100), (5, 'Sevilla', 350)");
		Java_SQL.insertData(conexion, "UD18_EJ3", "cajas",
				"(codigo, contenido, valor, almacen) VALUES ('ASD12', 'Papel', 100, 1), "
						+ "('ASD13', 'Cemento', 400, 2), ('ASD14', 'Monitores', 150, 3), "
						+ "('ASD15', 'Perfumes', 50, 4), ('ASD16', 'Ratones', 500, 5)");

		// Close connection
		Java_SQL.closeConnection(conexion);

	}

}
