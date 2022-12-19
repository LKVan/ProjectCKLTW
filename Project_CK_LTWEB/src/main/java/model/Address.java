package model;

public class Address {
	private String id;
	private String name;
	private String type;
	private String parentId;

	public Address(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Address(String id, String name, String type, String parentId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}

}
