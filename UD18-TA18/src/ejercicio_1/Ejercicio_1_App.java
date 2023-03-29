package ejercicio_1;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_1_App {

	public static void main(String[] args) {

		// Create connection
		Connection conexion = Java_SQL.conectarDB();

		// Create DB
		Java_SQL.createDB("UD18_EJ1", conexion);

		// Create Tables
		Java_SQL.createTable(conexion, "UD18_EJ1", "fabricantes", "(codigo INT PRIMARY KEY, nombre VARCHAR(100))");
		Java_SQL.createTable(conexion, "UD18_EJ1", "articulos",
				"(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, precio INT NOT NULL, "
						+ "fabricante INT NOT NULL, FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo))");

		// Add values
		Java_SQL.insertData(conexion, "UD18_EJ1", "fabricantes",
				"(codigo, nombre) VALUES (1, 'MSI'), (2, 'ASUS'), (3, 'Gigabyte'), (4, 'Zotac'), (5, 'LG')");
		Java_SQL.insertData(conexion, "UD18_EJ1", "articulos",
				"(nombre, precio, fabricante) VALUES ('Monitor', 200, 1), ('GPU', 400, 2), ('Placa Base', 150, 3), "
						+ "('Fuente de Alimentacion', 80, 4), ('Smartphone', 599, 5)");

		// Close connection
		Java_SQL.closeConnection(conexion);

	}

}
