package model;

public class Order {
	private int orderId;
	private String userName;
	private String email;
	private String productName;
	private int productPrice;
	private int quanlity;
	private int status;

	public Order(int orderId, String userName, String email, String productName, int productPrice, int quanlity,
			int status) {
		this.orderId = orderId;
		this.userName = userName;
		this.email = email;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quanlity = quanlity;
		this.status = status;
	}






	public Order(int orderId, String userName, String productName, int productPrice, int quanlity) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quanlity = quanlity;
	}

	

	public Order(int orderId, String userName, String email, String productName, int productPrice, int quanlity) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.email = email;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quanlity = quanlity;
	}



	public int getOrderId() {
		return orderId;
	}
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userName=" + userName + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", quanlity=" + quanlity + "]" + status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	

}
