package model;

public class Product {
	private int id;
	private String name;
	private String descreption;
	private int price;
	private String image;
	private int catId;

	public Product(int id, String name, String descreption, int price, String image) {
		this.id = id;
		this.name = name;
		this.descreption = descreption;
		this.price = price;
		this.image = image;
	}
	


	public Product(int id, String name, String descreption, int price, String image, int catId) {
		super();
		this.id = id;
		this.name = name;
		this.descreption = descreption;
		this.price = price;
		this.image = image;
		this.catId = catId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public int getCatId() {
		return catId;
	}



	public void setCatId(int catId) {
		this.catId = catId;
	}



	public  String formatPrice() {
		String fm = price + "";
		String result = "";
		int count = 0;
		for (int i = fm.length() - 1; i >= 0; i--) {
			result = fm.charAt(i) + result;
			count++;
			if (count == 3 && i != 0) {
				result = "." + result;
				count = 0;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descreption=" + descreption + ", price=" + price + ", image="
				+ image + ", cate ID: " + catId;
	}
	

}
