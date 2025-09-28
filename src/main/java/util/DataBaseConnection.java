package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBaseConnection {
	private static final String URL = "jdbc:mariadb://localhost:3306/gestor_nominas";
	private static final String USER = "nominas_user";
	private static final String PASSWORD = "1234";

	private DataBaseConnection() {

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void closeConnection(Connection c) {
		if (c != null)
			try {
				c.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar conexión: "+e.getMessage());
				e.printStackTrace();
			}
	}

	public static Connection getTxConnection() throws SQLException {
		Connection c = getConnection();
		c.setAutoCommit(false);
		return c;
	}

	public static void commitAndClose(Connection c) {
		if (c != null) {
			try {
				c.commit();
			} catch (SQLException e) {
				System.out.println("Error al cerrar conexión: "+e.getMessage());
				e.printStackTrace();
			}
			closeConnection(c);
		}
	}

	public static void rollbackAndClose(Connection c) {
		if (c != null) {
			try {
				c.rollback();
			} catch (SQLException e) {
				System.out.println("Error al hacer rollback: "+e.getMessage());
				e.printStackTrace();
			}
			closeConnection(c);
		}
	}
}
