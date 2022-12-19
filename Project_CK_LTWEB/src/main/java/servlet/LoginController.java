package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDAO;
import dao.UserDAO;
import model.Address;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession(true);
		Map<String, String> message = new HashMap<>();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String logOut = request.getParameter("logOut");
		String error = request.getParameter("error");

		User user = userDAO.getUser(userName);
		System.out.println(userName);
		request.setAttribute("message", message);

		if (logOut != null) {
			request.removeAttribute("message");
			session.removeAttribute("user");
			response.sendRedirect("HomeController");
		} else if (error != null) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		} else if (user != null) {
			if (user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				CartController cart = new CartController();
				cart.reCart(request);
				session.setMaxInactiveInterval(5000);
				if (user.getRolId() == 1)
					// request.getRequestDispatcher("/admin/adminHeader.jsp").forward(request,
					// response);
					response.sendRedirect("/Project_CK_LTWEB/admin");
				else
					response.sendRedirect("HomeController");
			} else {
				message.put("passwordError", "Sai Mật Khẩu");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			message.put("userError", "Tài khoản không tồn tại");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}

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
