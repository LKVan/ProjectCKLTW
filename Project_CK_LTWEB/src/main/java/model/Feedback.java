package model;

public class Feedback {
	private int id;
	private String fullName;
	private String phone;
	private String title;
	private String descreption;

	public Feedback(int id, String fullName, String phone, String title, String descreption) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.title = title;
		this.descreption = descreption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

}
