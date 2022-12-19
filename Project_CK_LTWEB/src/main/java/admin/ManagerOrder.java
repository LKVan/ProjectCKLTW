package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;

/**
 * Servlet implementation class ManagerOrder
 */
@WebServlet("/order")
public class ManagerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerOrder() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		OrderDAO orderDAO = new OrderDAO();

		if (action != null) {
			if (action.trim().equals("accept")) {
				List<Order> listOrder = orderDAO.getOrderByStatus(1); // Status = 1 la cho xac nhan
				request.setAttribute("listOrder", listOrder);
				request.getRequestDispatcher("/admin/orderAccept.jsp").forward(request, response);

			} else if (action.trim().equals("wating")) {
				List<Order> listOrder = orderDAO.getOrderByStatus(2);// Status = 2 la cho van chuyen
				request.setAttribute("listOrder", listOrder);
				request.getRequestDispatcher("/admin/orderWatting.jsp").forward(request, response);
			} else if (action.trim().equals("move")) {
				List<Order> listOrder = orderDAO.getOrderByStatus(3);// Status = 3 la dang van chuyen
				request.setAttribute("listOrder", listOrder);
				request.getRequestDispatcher("/admin/orderMoving.jsp").forward(request, response);
			}
			else if (action.trim().equals("finish")) {
				List<Order> listOrder = orderDAO.getOrderByStatus(4);// Status = 4 la da giao thanh cong
				request.setAttribute("listOrder", listOrder);
				request.getRequestDispatcher("/admin/orderFinish.jsp").forward(request, response);
			}else if (action.trim().equals("destroy")) {
				List<Order> listOrder = orderDAO.getOrderByStatus(0);// Status = 0 don bi huy
				request.setAttribute("listOrder", listOrder);
				request.getRequestDispatcher("/admin/orderTrash.jsp").forward(request, response);
			}else {
				response.sendRedirect("/Project_CK_LTWEB/404.html");
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
