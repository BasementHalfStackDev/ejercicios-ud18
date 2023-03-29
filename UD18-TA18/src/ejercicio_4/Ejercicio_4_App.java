package ejercicio_4;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_4_App {

	public static void main(String[] args) {
		Connection conexion = Java_SQL.conectarDB();
		String db = "UD18_EJ4";
		Java_SQL.createDB(db, conexion);
		Java_SQL.createTable(conexion, db, "peliculas", 
			"( "
			+ "	   codigo int primary key, "
			+ "    nombre varchar(100) not null, "
			+ "    calificacion_edad int not null "
			+ ")");
		Java_SQL.createTable(conexion, db, "salas", 
			"( "
			+ "	   codigo int primary key, "
			+ "    nombre varchar(100), "
			+ "    pelicula int references peliculas "
			+ ")");
		Java_SQL.insertData(conexion, db, "peliculas", 
			"(codigo, nombre, calificacion_edad) values"
			+ "	   (1, \"La la land\", 7),"
			+ "    (2, \"Joker\", 16),"
			+ "    (3, \"Parasitos\", 18),"
			+ "    (4, \"Toy story\", 0),"
			+ "    (6, \"Luca\", 0)");
		Java_SQL.insertData(conexion, db, "salas", 
			"(codigo, nombre, pelicula) values"
			+ "	   (1, \"gran\", 1),"
			+ "    (2, \"petita\", 4),"
			+ "    (3, \"classica\", 3),"
			+ "    (4, \"nova\", null),"
			+ "    (5, \"vella\", null)");

	}

}
