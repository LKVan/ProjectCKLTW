package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private final String serverName = "localhost";
	private final String dbName = "web";
	private final String portNumber = "3306";
	private final String user = "root";
	private final String password = "";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}
	public static void main(String[] args) {
		DBContext db  = new DBContext();
		
		try {
			Connection connect = db.getConnection();
			System.out.println(connect.getCatalog());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
