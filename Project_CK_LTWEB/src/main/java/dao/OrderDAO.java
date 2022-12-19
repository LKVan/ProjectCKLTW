package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Order;
import model.Product;

public class OrderDAO {
	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public List<Order> getOrderByStatus(int status) {
		List<Order> list = new ArrayList<>();

		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT (order.id),user.userName,user.email,product.name,cthd.price,cthd.quanlity FROM `order`,user,product,cthd\r\n"
					+ "WHERE (order.user_id) = user.id AND (order.id) = cthd.oder_id AND cthd.product_id = product.id AND (order.status) = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, status);
			result = ps.executeQuery();
			while (result.next()) {
				Order order = new Order(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getInt(5), result.getInt(6));
				list.add(order);
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

	public Order getOrderByID(int id) {
		Order order = null;

		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT (order.id),user.userName,user.email,product.name,cthd.price,cthd.quanlity FROM `order`,user,product,cthd\r\n"
					+ "WHERE (order.user_id) = user.id AND (order.id) = cthd.oder_id AND cthd.product_id = product.id AND (order.id) = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				order = new Order(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getInt(5), result.getInt(6));
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

		return order;
	}

	public List<Order> getOrderByUserID(int id) {
		List<Order> list = new ArrayList<>();

		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT (order.id),user.userName,user.email,product.name,cthd.price,cthd.quanlity,(order.status) FROM `order`,user,product,cthd\r\n"
					+ "WHERE (order.user_id) = user.id AND (order.id) = cthd.oder_id AND cthd.product_id = product.id AND (order.user_id) = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new Order(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getInt(5), result.getInt(6),result.getInt(7)));
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

	public int changeStatusOrder(int orderId, int status) {
		DBContext db = new DBContext();
		int numberRowChange = 0;

		try {
			connect = db.getConnection();
			String query = "UPDATE `order` SET `status` = ? WHERE (order.id) = ?; ";
			ps = connect.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, orderId);
			numberRowChange = ps.executeUpdate();
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numberRowChange;

	}

	public int delete(int orderId) {
		DBContext db = new DBContext();
		int numberRowChange = 0;

		try {
			connect = db.getConnection();
			String deleteCTHD = "Delete from `cthd` WHERE (cthd.oder_id) = ?;";
			ps = connect.prepareStatement(deleteCTHD);
			ps.setInt(1, orderId);
			ps.executeUpdate();
			ps.clearParameters();

			String query = "Delete from `order` WHERE (order.id) = ?; ";
			ps = connect.prepareStatement(query);
			ps.setInt(1, orderId);
			numberRowChange = ps.executeUpdate();
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numberRowChange;

	}

	public static void main(String[] args) {
		OrderDAO orderDAO = new OrderDAO();

		List<Order> order = orderDAO.getOrderByStatus(1);
		System.out.println(order.toString());
	}

}
