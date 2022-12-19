package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeedbackDAO;

/**
 * Servlet implementation class FeedBackController
 */
@WebServlet("/FeedBackController")
public class FeedBackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedBackController() {
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

//		request.getRequestDispatcher("/feedback.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String title = request.getParameter("title");
		String note = request.getParameter("note");

		FeedbackDAO feedbackDAO = new FeedbackDAO();

		feedbackDAO.insert(name, phone, title, note);

		request.setAttribute("sucess", "Gửi phản hồi thành công!");
		request.getRequestDispatcher("/feedback.jsp").forward(request, response);
	}

}
