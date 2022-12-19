package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeedbackDAO;
import model.Feedback;

/**
 * Servlet implementation class ManagerFeedback
 */
@WebServlet("/ManagerFeedback")
public class ManagerFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FeedbackDAO feedDAO = new FeedbackDAO();
		String action = request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//request.setCharacterEncoding("UTF-8");
		

		if (action != null) {
			if (action.equals("trash")) {
				String idFeed = request.getParameter("feedId");
				feedDAO.delete(Integer.parseInt(idFeed));
				request.setAttribute("success", "Xoá thành công");
				request.getRequestDispatcher("/admin/manager_feedback.jsp").forward(request, response);
			}else if(action.equals("show")) {
				String idFeed = request.getParameter("feedId");
				Feedback feed = feedDAO.get(Integer.parseInt(idFeed));
				request.setAttribute("feed", feed);
				request.getRequestDispatcher("/admin/feedbackDetail.jsp").forward(request, response);
			}
		} else {
			List<Feedback> listFeedback = feedDAO.getAllFeedBack();
			request.setAttribute("listFeedback", listFeedback);
			request.getRequestDispatcher("/admin/manager_feedback.jsp").forward(request, response);

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
