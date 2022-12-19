package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Feedback;

public class FeedbackDAO {

	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public int insert(String fullName, String phone, String subject, String note) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "INSERT INTO feedback(fullName,phone,subject,note_) VALUES (?,?,?,?)";
			ps = connect.prepareStatement(query);
			ps.setString(1, fullName);
			ps.setString(2, phone);
			ps.setString(3, subject);
			ps.setString(4, note);
			int row = ps.executeUpdate();
			return row;
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

	public int delete(int idFeed) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "Delete from feedback where id = ?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, idFeed);
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

	public Feedback get(int idFeed) {
		DBContext db = new DBContext();
		Feedback feed = null;
		try {
			connect = db.getConnection();
			String query = "Select * from feedback where id = ?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, idFeed);

			result = ps.executeQuery();

			while (result.next()) {
				feed = new Feedback(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5));
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

		return feed;
	}

	public List<Feedback> getAllFeedBack() {
		DBContext db = new DBContext();
		List<Feedback> resultList = new ArrayList<>();

		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `feedback` ";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();

			while (result.next()) {
				resultList.add(new Feedback(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getString(5)));
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

		return resultList;
	}
}
