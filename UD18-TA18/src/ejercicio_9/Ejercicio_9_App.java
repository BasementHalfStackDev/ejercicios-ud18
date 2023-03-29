package ejercicio_9;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_9_App {

	public static void main(String[] args) {
		// Create connection
		Connection conexion = Java_SQL.conectarDB();

		// Create DB
		Java_SQL.createDB("UD18_EJ9", conexion);

		// Create Tables
		Java_SQL.createTable(conexion, "UD18_EJ9", "facultad",
				"(codigo INT PRIMARY KEY, nombre VARCHAR(100) NOT NULL)");
		Java_SQL.createTable(conexion, "UD18_EJ9", "investigadores",
				"(DNI VARCHAR(9) PRIMARY KEY, nombre VARCHAR(255) NOT NULL, facultad INT NOT NULL,"
						+ "FOREIGN KEY (facultad) REFERENCES facultad(codigo))");
		Java_SQL.createTable(conexion, "UD18_EJ9", "equipos",
				"(num_serie CHAR(4) PRIMARY KEY, nombre VARCHAR(100) NOT NULL, facultad INT NOT NULL,"
						+ "FOREIGN KEY (facultad) REFERENCES facultad(codigo))");
		Java_SQL.createTable(conexion, "UD18_EJ9", "reserva",
				"(investigador VARCHAR(9), equipo CHAR(4), comienzo DATE NOT NULL, fin DATE NOT NULL,"
						+ "PRIMARY KEY (investigador, equipo),"
						+ "FOREIGN KEY (investigador) REFERENCES investigadores(DNI),"
						+ "FOREIGN KEY (equipo) REFERENCES equipos(num_serie))");

		// Add values
		Java_SQL.insertData(conexion, "UD18_EJ9", "facultad",
				"(codigo, nombre) VALUES (1, 'Facultad de ciencias'), (2, 'Facultad de derecho'), "
						+ "(3, 'Facultad de medicina'), (4, 'Facultad de psicologia'), (5, 'Facultad sinnombre')");

		Java_SQL.insertData(conexion, "UD18_EJ9", "investigadores",
				"(DNI, nombre, facultad) VALUES " 
						+ "('12345678A', 'Mister ciencia', 1),"
						+ "('12345678B', 'Mister izquierdo', 2),"
						+ "('12345678C', 'Mister salud', 3),"
						+ "('12345678D', 'Mister psico', 4),"
						+ "('12345678E', 'Mister null', 5)");

		Java_SQL.insertData(conexion, "UD18_EJ9", "equipos",
				"(num_serie, nombre, facultad) VALUES " 
						+ "('ABC1', 'Equipo A', 1)," 
						+ "('ABC2', 'Equipo B', 2),"
						+ "('ABC3', 'Equipo C', 3)," 
						+ "('ABC4', 'Equipo D', 4)," 
						+ "('ABC5', 'Equipo E', 5),"
						+ "('ABC6', 'Equipo F', 2)");
		
		Java_SQL.insertData(conexion, "UD18_EJ9", "reserva",
				"(investigador, equipo, comienzo, fin) VALUES " 
						+ "('12345678A', 'ABC1', '2022-01-01', '2023-01-01')," 
						+ "('12345678B', 'ABC2', '2023-01-01', '2023-02-01'),"
						+ "('12345678C', 'ABC3', '2023-03-29', '2023-04-01')," 
						+ "('12345678D', 'ABC4', '2023-02-14', '2023-02-15')," 
						+ "('12345678E', 'ABC5', '2023-05-01', '2023-07-23'),"
						+ "('12345678C', 'ABC6', '2023-04-02', '2023-05-15')");

		// Close connection
		Java_SQL.closeConnection(conexion);

	}

}
