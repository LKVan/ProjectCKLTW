package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;
import support.SendEmail;

/**
 * Servlet implementation class OrderAction
 */
@WebServlet("/oderAction")
public class OrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		OrderDAO orderDAO = new OrderDAO();

		if (action != null) {
			if (action.trim().equals("confim")) {
				String orderId = request.getParameter("orderID");
				orderDAO.changeStatusOrder(Integer.parseInt(orderId), 2);
				Order order = orderDAO.getOrderByID(Integer.parseInt(orderId));
				String subject = "Shop Đồ Ăn Vặt Handmade";
				String content = "Dear " + order.getUserName() + "\n\nĐơn hàng (ID order): " + order.getOrderId() + ",Sản phẩm : "
						+ order.getProductName() + " đã được xác nhận.\n\n"
						+ "Đơn hàng sẽ được giao đến quý khách một ngày sớm nhất.\n\nCảm ơn quý khách đã tin tưởng!. <3";

				SendEmail.sendEmail(order.getEmail(), subject, content);

				request.setAttribute("access", "yes");
				request.getRequestDispatcher("/order?action=accept").forward(request, response);
			} else if (action.trim().equals("delete")) {
				String orderId = request.getParameter("orderID");
				orderDAO.changeStatusOrder(Integer.parseInt(orderId), 0);
				request.setAttribute("delete", "yes");
				request.getRequestDispatcher("/order?action=accept").forward(request, response);
			} else if (action.trim().equals("ship")) {
				String orderId = request.getParameter("orderID");
				orderDAO.changeStatusOrder(Integer.parseInt(orderId), 3);
				request.setAttribute("access", "yes");
				request.getRequestDispatcher("/order?action=wating").forward(request, response);
			} else if (action.trim().equals("destroy")) {
				String orderId = request.getParameter("orderID");
				orderDAO.delete(Integer.parseInt(orderId));
				request.setAttribute("access", "yes");
				request.getRequestDispatcher("/order?action=destroy").forward(request, response);
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
