package servlet;

import java.io.IOException;
import java.net.URLDecoder;
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
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		AddressDAO addressDAO = new AddressDAO();
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession(true);
		Map<String, String> message = new HashMap<>();

		System.out.println(request.getCharacterEncoding());

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		User user = userDAO.getUser(userName);
		request.setAttribute("message", message);
		
		if(userName.length() < 10) {
			message.put("userError", "Tài khoản phải dài hơn 10 kí tự!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else
		if (user != null) {
			message.put("userError", "Tài khoản đã tồn tại!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			;
		} else {
			String rePassword = request.getParameter("rePassword");
			if (password.length() < 10) {
				message.put("password", "Mật khẩu phải dài hơn 10 kí tự!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} else if (password.equals(rePassword)) {
				String fullName = request.getParameter("fullName");

				System.out.println(fullName);
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");

				Address city = addressDAO.getProvince(request.getParameter("province"));
				Address ditricts = addressDAO.getDistrict(request.getParameter("district"));
				Address ward = addressDAO.getWard(request.getParameter("ward"));
				String address = request.getParameter("addressDetail") + "," + ward.toString() + ","
						+ ditricts.toString() + "," + city.toString();

				User newUser = new User(fullName, phone, address, userName, password, 2,email);
				int id = userDAO.insertUser(newUser);
				newUser.setId(id);
				session.setAttribute("user", newUser);
				response.sendRedirect("/Project_CK_LTWEB/HomeController");
			} else {
				message.put("passwordError", "Mật khẩu không trùng khớp!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
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
