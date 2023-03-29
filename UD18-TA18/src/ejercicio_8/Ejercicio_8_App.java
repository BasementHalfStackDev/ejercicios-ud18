package ejercicio_8;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_8_App {

	public static void main(String[] args) {
		Connection conexion = Java_SQL.conectarDB();
		String db = "UD18_EJ8";
		Java_SQL.createDB(db, conexion);
		Java_SQL.createTable(conexion, db, "productos", 
				  "(\r\n"
				  + "	codigo int primary key,\r\n"
				  + "    nombre varchar(100) not null,\r\n"
				  + "    precio int not null\r\n"
				  + ")");
		Java_SQL.createTable(conexion, db, "cajeros", 
				  "(\r\n"
				  + "	codigo int primary key,\r\n"
				  + "    nom_apels varchar(255) not null\r\n"
				  + ")");
		Java_SQL.createTable(conexion, db, "maquinas_registradoras", 
				  "(\r\n"
				  + "	codigo int primary key,\r\n"
				  + "    piso int not null\r\n"
				  + ")");
		Java_SQL.createTable(conexion, db, "venta", 
				  "(\r\n"
				  + "	cajero int references cajeros,\r\n"
				  + "    maquina int references maquinas_registradoras,\r\n"
				  + "    producto int references productos,\r\n"
				  + "	primary key (cajero, maquina, producto)\r\n"
				  + ")");
		
		Java_SQL.insertData(conexion, db, "productos", 
				  "(codigo, nombre, precio) VALUES\r\n"
				  + "(1, \"Camiseta\", 15),\r\n"
				  + "(2, \"Pantalón\", 25),\r\n"
				  + "(3, \"Calcetines\", 5),\r\n"
				  + "(4, \"Gorra\", 10),\r\n"
				  + "(5, \"Zapatillas\", 50)");
		Java_SQL.insertData(conexion, db, "cajeros", 
				  "(codigo, nom_apels) VALUES\r\n"
				  + "(1, \"Ana Pérez López\"),\r\n"
				  + "(2, \"Juan Martínez García\"),\r\n"
				  + "(3, \"María Rodríguez Gómez\"),\r\n"
				  + "(4, \"Carlos Fernández Martín\"),\r\n"
				  + "(5, \"Laura Sánchez Ruiz\")");
		Java_SQL.insertData(conexion, db, "maquinas_registradoras", 
				  "(codigo, piso) VALUES\r\n"
				  + "(1, 1),\r\n"
				  + "(2, 2),\r\n"
				  + "(3, 1),\r\n"
				  + "(4, 3),\r\n"
				  + "(5, 2)");
		Java_SQL.insertData(conexion, db, "venta", 
				  "(cajero, maquina, producto) VALUES\r\n"
				  + "(1, 2, 3),\r\n"
				  + "(2, 1, 2),\r\n"
				  + "(3, 4, 1),\r\n"
				  + "(4, 5, 4),\r\n"
				  + "(5, 3, 5)");
		

	}

}
