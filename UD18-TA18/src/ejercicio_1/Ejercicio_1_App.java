package ejercicio_1;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_1_App {

	public static void main(String[] args) {

		Connection conexion = Java_SQL.conectarDB();

		Java_SQL.createDB("UD18_EJ1", conexion);

		Java_SQL.createTable(conexion, "UD18_EJ1", "fabricantes",
				"(codigo INT PRIMARY KEY, nombre VARCHAR(100))");
		Java_SQL.createTable(conexion, "UD18_EJ1", "articulos",
				"(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, precio INT NOT NULL, "
				+ "fabricante INT NOT NULL, FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo))");
		
		

		Java_SQL.closeConnection(conexion);

	}

}
