package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import context.DBContext;

public class DAO {
	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	
	
	public void testConnect() {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `product`;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			int i = 1;
			while(result.next()) {
				System.out.print("STT:"+ result.getInt(1)+"\t"+result.getString(2)+"\t"+ result.getString(3)+"\t"+
						result.getInt(4)+"\t"+ result.getString(5));
				System.out.println();
				i++;
			}
			ps.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	public static void main(String[] args) {
		new DAO().testConnect();
	}
}
