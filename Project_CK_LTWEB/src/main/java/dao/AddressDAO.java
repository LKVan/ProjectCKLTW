package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Address;
import model.Product;

public class AddressDAO {

	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public Address getProvince(String id) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `province` WHERE province.id = ?";
			ps = connect.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				return new Address(result.getString(1), result.getString(2), result.getString(3));
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

	public Address getDistrict(String id) {
		DBContext db = new DBContext();

		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `district` WHERE district.id = ?";
			ps = connect.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				return new Address(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
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

	public Address getWard(String id) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `ward` WHERE ward.id = ?";
			ps = connect.prepareStatement(query);
			ps.setString(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				return new Address(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
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

	

	public static void main(String[] args) {
		System.out.println(new AddressDAO().getProvince("01"));
	}

}
