package Program;

import java.sql.*;

public class Program {
	public static void main(String args[]) {
		System.out.printf("Init\n");
		
		try (
				Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/myDB.db");
				Statement stmt = conn.createStatement();
				) {
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet res = meta.getTables(null, null, "PERSONA", null);
			
			if (res.next()) {
				System.out.printf("La Tabla ya existe.\n");
			} else {
				String sql = "CREATE TABLE PERSONA " +
		                   "(id INTEGER not NULL, " +
		                   "data INTEGER NULL, " +
		                   " PRIMARY KEY ( id ))"; 
				stmt.executeUpdate(sql);
				
				System.out.printf("[%s]\nTabla creada...\n", sql);
			}
			
			for (int i = 0; i < 100; i++) {
				stmt.executeUpdate(String.format("INSERT INTO PERSONA(id, data) VALUES(%d, %d)", i, i*2));
			}
			System.out.printf("Finalización de carga...\n");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Fin programa.\n");
	}
}
