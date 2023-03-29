package ejercicio_1;

import java.sql.Connection;

import java_sql_utils.Java_SQL;


public class Ejercicio_1_App {

	public static void main(String[] args) {
		
		Connection conexion = Java_SQL.conectarDB();
		
		Java_SQL.createDB("UD18-EJ1", conexion);
		
		Java_SQL.createTable(conexion, null, null, null);
		
		Java_SQL.closeConnection(conexion);

	}

}
