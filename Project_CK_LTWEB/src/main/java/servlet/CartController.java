package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import dao.OderAndCTHDDAO;
import dao.CartDAO;
import dao.ProductDAO;
import model.Cart;
import model.CartItem;
import model.Product;
import model.TempCart;
import model.User;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String iAction = request.getParameter("action");
		HttpSession session = request.getSession();
		Object objUser = session.getAttribute("user");

		if (iAction != null && !iAction.equals("")) {
			if (iAction.equals("delete")) {
				deleteCart(request);
				response.sendRedirect("cart.jsp");

			} else if (iAction.equals("oder")) {
				addToCTHDandOder(request);
				deleteCart(request);
				response.sendRedirect("cart.jsp");
			} else if (iAction.equals("usercart")) {
				reCart(request);
				response.sendRedirect("cart.jsp");
			} else if (iAction.equals("update")) {
				updateCart(request);
				response.sendRedirect("cart.jsp");
			}
		} else {
			if (objUser != null) {
				reCart(request);
				addToCart(request);
				response.sendRedirect("cart.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		}
	}

	protected void addToCTHDandOder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		OderAndCTHDDAO db = new OderAndCTHDDAO();

		String cartId = request.getParameter("cart_pro_id");
		String quantity = request.getParameter("quan");
		String price = request.getParameter("price");

		User user = null;

		Object objUser = session.getAttribute("user");

		if (objUser != null) {
			user = (User) objUser;
		}
		Long time = System.currentTimeMillis();
		int temp = db.insertOder(user.getId(), "", new java.sql.Date(time), 1);
		db.insertCTHD(temp, Integer.parseInt(cartId), Integer.parseInt(price), Integer.parseInt(quantity));

	}

	protected void deleteCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CartDAO cartdb = new CartDAO();
		String iSTT = request.getParameter("stt");
		String pro_id = request.getParameter("cart_pro_id");
		String quantity = request.getParameter("quan");

		Cart cartBean = null;

		Object iObject = session.getAttribute("cart");

		if (iObject != null) {
			cartBean = (Cart) iObject;
		} else {
			cartBean = new Cart();
		}
		User user = null;

		Object objUser = session.getAttribute("user");

		if (objUser != null) {
			user = (User) objUser;
		}

		cartBean.deleteCart(iSTT);
		cartdb.deleteCart(user.getId(), Integer.parseInt(pro_id), Integer.parseInt(quantity));
	}

	protected void addToCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CartDAO cartdb = new CartDAO();

		String pro_id = request.getParameter("proId");
		ProductDAO pd = new ProductDAO();
		Product product = pd.getProductById(Integer.parseInt(pro_id));

		String iname = product.getName();
		String iimage = product.getImage();
		String idescription = product.getDescreption();
		int iPrice = product.getPrice();
		String iQuantity = request.getParameter("inputQuantity");

		Cart cartBean = null;

		User user = null;

		Object objCartBean = session.getAttribute("cart");

		Object objUser = session.getAttribute("user");

		if (objUser != null) {
			user = (User) objUser;
		}
		if (objCartBean != null) {
			cartBean = (Cart) objCartBean;

		} else {
			cartBean = new Cart();
			session.setAttribute("cart", cartBean);
		}

		cartBean.addCart(pro_id, iname, iimage, idescription, iPrice, iQuantity);
		if (cartdb.getCartByUserIdAndProductId(user.getId(), Integer.parseInt(pro_id)).size() > 0) {
			cartdb.updateTempcart(user.getId(), Integer.parseInt(pro_id), Integer.parseInt(iQuantity));
		} else {
			cartdb.insertTempcart(user.getId(), Integer.parseInt(pro_id), Integer.parseInt(iQuantity));
		}
	}

	protected void reCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CartDAO cartdb = new CartDAO();
		ProductDAO pd = new ProductDAO();

		Cart cartBean = null;
		User user = null;

		Object objUser = session.getAttribute("user");

		Object objCartBean = session.getAttribute("cart");

		if (objUser != null) {
			user = (User) objUser;
		} else {
			System.out.println("ncc");
		}

		if (objCartBean != null) {
			objCartBean = null;
			cartBean = new Cart();
			session.setAttribute("cart", cartBean);
		} else {
			cartBean = new Cart();
			session.setAttribute("cart", cartBean);
		}

		List<TempCart> list = cartdb.getCartByUserId(user.getId());
		for (TempCart tempCart : list) {
			Product product = pd.getProductById(tempCart.getProId());
			String ipro_id = tempCart.getProId() + "";
			String iname = product.getName();
			String iimage = product.getImage();
			String idescription = product.getDescreption();
			int iPrice = product.getPrice();
			String iQuantity = "" + tempCart.getQuantity();
			cartBean.addCart(ipro_id, iname, iimage, idescription, iPrice, iQuantity);

		}
	}

	protected void updateCart(HttpServletRequest request) {
		HttpSession session = request.getSession();

		CartDAO db = new CartDAO();
		User user = null;
		String pro_id = request.getParameter("cart_pro_id");
		Object objUser = session.getAttribute("user");

		if (objUser != null) {
			user = (User) objUser;
		}

		String iQuantity = request.getParameter("quan");
		String iSTT = request.getParameter("stt");

		Cart cartBean = null;

		Object objCartBean = session.getAttribute("cart");
		if (objCartBean != null) {
			cartBean = (Cart) objCartBean;
		} else {
			cartBean = new Cart();
		}
		cartBean.updateCart(iSTT, iQuantity);
		db.updateTempcart(user.getId(), Integer.parseInt(pro_id), Integer.parseInt(iQuantity));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
