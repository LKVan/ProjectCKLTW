package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext context = request.getServletContext();
		request.setCharacterEncoding("UTF-8");
		ProductDAO productDAO = new ProductDAO();
		
		
		String name = request.getParameter("search");
		String result = "Không tìm thấy kết quả cho '" + name + "'";
		
		List<Product> listProduct = productDAO.getProductByName(name);
		if (listProduct.size() > 0) {
			result = "Kết quả có liên quan cho '" + name + "'";
		}
		
		request.setAttribute("maintitle", result);
		request.setAttribute("listProduct", listProduct);

		List<Product> listProductNew = productDAO.getNewProduct();
		request.setAttribute("listProductNew", listProductNew);

		request.getRequestDispatcher("/home.jsp").forward(request, response);

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
