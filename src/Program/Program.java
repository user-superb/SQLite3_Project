package Program;

import java.sql.*;

public class Program {
	public static void main(String args[]) {
		System.out.printf("Init\n");
		
		try (
				Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/myDB.db");
				Statement stmt = conn.createStatement();
				) {
			String sql = "CREATE TABLE PERSONA " +
	                   "(id INTEGER not NULL, " +
	                   " PRIMARY KEY ( id ))"; 
			stmt.executeUpdate(sql);
			
			System.out.printf("[%s]\nTabla creada...\n", sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
