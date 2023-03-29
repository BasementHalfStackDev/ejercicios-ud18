package Ejercicio_6;

import java.sql.Connection;

import java_sql_utils.Java_SQL;

public class Ejercicio_6_Piezas {
	public static void main(String[] args) {
		Connection conexion = Java_SQL.conectarDB();
		String db = "UD18_EJ6";
		Java_SQL.createDB(db, conexion);
		Java_SQL.createTable(conexion, db, "piezas", 
				"(codigo int primary key, nombre varchar(100) not null)");
		Java_SQL.createTable(conexion, db, "proveedores", 
				"(id char(4) primary key, nombre varchar(100) not null)");
		Java_SQL.createTable(conexion, db, "suministra",
				"( "
				+ "	   codigo_pieza int references pieza, "
				+ "    id_proveedor char(4) references proveedores, "
				+ "    precio int not null, "
				+ "    primary key (codigo_pieza, id_proveedor) "
				+ ")");
		Java_SQL.insertData(conexion, db, "piezas", 
				"(codigo, nombre) VALUES"
				+ "(1, \"Tornillo\"),"
				+ "(2, \"Arandela\"),"
				+ "(3, \"Tuerca\"),"
				+ "(4, \"Resistor\"),"
				+ "(5, \"Capacitor\")");
		Java_SQL.insertData(conexion, db, "proveedores", 
				"(id, nombre) VALUES"
				+ "(\"A001\", \"Proveedor 1\"),"
				+ "(\"B002\", \"Proveedor 2\"),"
				+ "(\"C003\", \"Proveedor 3\"),"
				+ "(\"D004\", \"Proveedor 4\"),"
				+ "(\"E005\", \"Proveedor 5\");");
		Java_SQL.insertData(conexion, db, "suministra", 
				"(codigo_pieza, id_proveedor, precio) VALUES"
				+ "(1, \"A001\", 10),"
				+ "(2, \"B002\", 5),"
				+ "(3, \"C003\", 3),"
				+ "(4, \"D004\", 2),"
				+ "(5, \"E005\", 8);");
	}
}
