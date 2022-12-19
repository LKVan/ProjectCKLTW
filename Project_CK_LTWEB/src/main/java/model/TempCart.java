package model;

public class TempCart {
	private int id;
	private int proId;
	private int quantity;

	public TempCart(int id, int proId, int quantity) {
		this.proId = proId;
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
