package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Category;

public class CategoryDAO {
	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `danhmuc`;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Category cate = new Category(result.getInt(1), result.getString(2));
				list.add(cate);
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

		return list;
	}

}
