package model;

import java.util.ArrayList;

import dao.CartDAO;

public class Cart {
	private ArrayList<CartItem> list = new ArrayList<>();
	private int total;

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLineItemCount() {
		return list.size();
	}

	public void deleteCart(String stt) {
		int iSTT = 0;
		try {
			iSTT = Integer.parseInt(stt);
			list.remove(iSTT - 1);
			calculateOrderTotal();
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void updateCart(String stt, String quantity) {
		int iSTT = Integer.parseInt(stt);
		CartItem cartItem = (CartItem) list.get(iSTT - 1);
		int iPrice = cartItem.getPrice();
		int iQuantity = Integer.parseInt(quantity);
		try {
			if (iQuantity > 0) {
				cartItem.setQuantity(iQuantity);
				cartItem.setTotalCost(iPrice * iQuantity);
				calculateOrderTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart: " + nfe.getMessage());
			nfe.printStackTrace();
		}

	}

	public void addCart(String pro_id, String name, String image, String desciption, int price, String quantity) {
		int iQuantity = Integer.parseInt(quantity);
		CartItem cartItem = new CartItem();
		boolean temp = false;
		try {
			if (iQuantity > 0) {
				for (CartItem item : list) {
					if (item.getId().equals(pro_id)) {
						item.setQuantity(iQuantity + item.getQuantity());
						calculateOrderTotal();
						temp = true;
					}
				}
				if (temp == false) {
				cartItem.setId(pro_id);
				cartItem.setName(name);
				cartItem.setPrice(price);
				cartItem.setImage(image);
				cartItem.setDescription(desciption);
				cartItem.setQuantity(iQuantity);
				cartItem.setTotalCost(price * iQuantity);
				list.add(cartItem);
				calculateOrderTotal();
				}
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	protected void calculateOrderTotal() {
		int plus = 0;
		for (int i = 0; i < list.size(); i++) {
			CartItem cartItem = (CartItem) list.get(i);
			plus += cartItem.getTotalCost();

		}
		setTotal(plus);
	}

	public String formatTotal() {
		String fm = total + "";
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
