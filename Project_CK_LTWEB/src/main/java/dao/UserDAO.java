package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Address;
import model.User;

public class UserDAO {
	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public List<User> getUserByRolId(int rolId) {
		DBContext db = new DBContext();
		List<User> list = new ArrayList<>();
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `user` WHERE user.rol_id = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, rolId);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6), result.getInt(7),result.getString(8)));
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

	public User getUser(String userName) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `user` WHERE user.userName = ?";
			ps = connect.prepareStatement(query);
			ps.setString(1, userName);
			result = ps.executeQuery();
			while (result.next()) {
				return new User(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getInt(7),result.getString(8));
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
		return null;
	}

	public User getUser(int id) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `user` WHERE user.id = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				return new User(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getInt(7),result.getString(8));
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
		return null;
	}

	public int insertUser(User user) {
		DBContext db = new DBContext();
		int id = 0;
		try {
			connect = db.getConnection();
			String query = "INSERT INTO user(fullname,phone,address,userName,password,rol_id,email) VALUES(?,?,?,?,?,2,?);";
			ps = connect.prepareStatement(query);

			ps.setString(1, user.getFullName());
			ps.setString(2, user.getNumberPhone());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getUserName());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getEmail());
			ps.executeUpdate();
			ps.clearParameters();
			
			ps = connect.prepareStatement("select `id` from `user` order by `id` desc limit 1;");
			result = ps.executeQuery();
			result.next();
			id = result.getInt(1);
			System.out.println(id);

			ps.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return id;
	}

	public int updateUser(User user) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "UPDATE user SET user.fullName = ?,user.phone = ?,user.address =? ,user.password =?,user.rol_id = ? where user.id = ?;";
			ps = connect.prepareStatement(query);

			ps.setString(1, user.getFullName());
			ps.setString(2, user.getNumberPhone());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getRolId());
			ps.setInt(6, user.getId());
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
			return numberRowUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteUser(int id) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "Delete from user where id = ?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, id);
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
			return numberRowUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(new UserDAO().getUser("admin"));
	}

}
