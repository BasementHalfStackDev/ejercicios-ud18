package ejercicio_2;

import java.sql.Connection;
import java_sql_utils.Java_SQL;


public class Ejercicio_2_App {
	
	public static void main(String[] args) {
		
		Connection conexion = Java_SQL.conectarDB();
		String db = "UD18_EJ2";
		Java_SQL.createDB(db, conexion);
		Java_SQL.createTable(conexion, db, "departamentos", 
				  "( "
				+ "    Codigo int primary key, "
				+ "    Nombre varchar(100) not null, "
				+ "    Presupuesto int not null "
				+ ")");
		Java_SQL.createTable(conexion, db, "empleados",
				  "("
				+ "	   DNI varchar(8) primary key,  "
				+ "    Nombre varchar(100) not null, "
				+ "    Apellidos varchar(255) not null, "
				+ "    Departamento int not null references departamentos "
				+ ")");
		Java_SQL.insertData(conexion, db, "departamentos", 
				"(Codigo, Nombre, Presupuesto) values "
				+ "	   (1, \"ventas\", 3000), "
				+ "    (2, \"marketing\", 2000), "
				+ "    (3, \"operaciones\", 5000), "
				+ "    (4, \"informatica\", 4000), "
				+ "    (5, \"finanzas\", 2000)");
		Java_SQL.insertData(conexion, db, "empleados", 
				"(DNI, Nombre, Apellidos, Departamento) values "
				+ "	   (\"1111111A\", \"Joan\", \"Lapeyra Amat\", 4), "
				+ "    (\"2222222B\", \"Josep Maria\", \"Pallàs Batalla\", 4), "
				+ "    (\"3333333C\", \"Ventura\", \"Gassol Rovira\", 1), "
				+ "    (\"4444444D\", \"Martí\", \"Esteve Guau\", 5), "
				+ "    (\"5555555E\", \"Joan\", \"Selves Carner\", 3)");
		Java_SQL.closeConnection(conexion);

	}

}
