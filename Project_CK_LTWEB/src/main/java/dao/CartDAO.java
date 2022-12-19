package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.TempCart;
import model.User;

public class CartDAO {
	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public List<TempCart> getCartByUserId(int id) {
		List<TempCart> list = new ArrayList<>();
		DBContext db = new DBContext();

		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `cart` WHERE cart.user_id = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new TempCart(result.getInt(1), result.getInt(3), result.getInt(4)));
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
	public List<TempCart> getCartByUserIdAndProductId(int user_id,int pro_id) {
		List<TempCart> list = new ArrayList<>();
		DBContext db = new DBContext();

		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `cart` WHERE cart.user_id = ? and cart.pro_id=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setInt(2, pro_id);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new TempCart(result.getInt(1), result.getInt(3), result.getInt(4)));
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

	public void insertTempcart(int user_id, int pro_id, int quantity) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "INSERT INTO `cart`(`user_id`, `pro_id`, `quantity`) VALUES (?,?,?);";
			ps = connect.prepareStatement(query);

			ps.setInt(1, user_id);
			ps.setInt(2, pro_id);
			ps.setInt(3, quantity);
			int numberRowUpdate = ps.executeUpdate();

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
	public void updateTempcart(int user_id, int pro_id, int quantity) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "UPDATE `cart` SET `quantity`=? WHERE `user_id`=? and `pro_id`=?";
			ps = connect.prepareStatement(query);

			ps.setInt(1, quantity);
			ps.setInt(2, user_id);
			ps.setInt(3, pro_id);
			int numberRowUpdate = ps.executeUpdate();

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


	public void deleteCart(int user_id,int pro_id,int quantity) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "Delete from cart where user_id=? and pro_id=? and quantity=?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, user_id);
			ps.setInt(2, pro_id);
			ps.setInt(3, quantity);
			int numberRowUpdate = ps.executeUpdate();

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
		
	}

}
