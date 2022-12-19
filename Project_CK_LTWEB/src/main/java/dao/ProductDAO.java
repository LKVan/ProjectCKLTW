package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ProductDAO {

	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public Product getProductById(int id) {
		DBContext db = new DBContext();
		Product product = null;
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `product` WHERE product.id = ? ;";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				product = new Product(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
						result.getString(5), result.getInt(6));
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
		return product;

	}

	// Lay tat ca san pham
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `product`;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
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

	// Lay theo danh muc
	public List<Product> getProductByCategory(int catId) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT* FROM product WHERE product.DanhMuc_id = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, catId);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
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
	// Lay ra san pham ban chay

	public List<Product> getProductSell() {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `product`;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
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

	// Lay ra san pham moi
	public List<Product> getNewProduct() {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `product` order BY id LIMIT 4;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
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

	// Lay san pham theo ten
	public List<Product> getProductByName(String name) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT* FROM product WHERE product.name Like ?";
			ps = connect.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
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

	public int update(Product product) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "UPDATE product SET product.name = ?,product.descreption = ?,product.price = ?,product.image =?,product.DanhMuc_id = ? WHERE id = ?;";
			ps = connect.prepareStatement(query);

			ps.setString(1, product.getName());
			ps.setString(2, product.getDescreption());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCatId());
			ps.setInt(6, product.getId());

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

	public int delete(int id) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "Delete from product where id = ?;";
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

	public int insert(String name, String des, int price, String image, int catId) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "INSERT INTO product(name,descreption,price,image,DanhMuc_id) VALUES(?,?,?,?,?);";
			ps = connect.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, des);
			ps.setInt(3, price);
			ps.setString(4, image);
			ps.setInt(5, catId);
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

}
