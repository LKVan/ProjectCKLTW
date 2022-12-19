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
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ServletContext context = getServletContext();
		
		ProductDAO productDAO = new ProductDAO();

//		String page = "home.jsp";
//		String title = "Tất cả sản phẩm";
//
//		context.setAttribute("page", page);
//		context.setAttribute("title", title);
		

		List<Product> listProduct = productDAO.getAllProduct();
		request.setAttribute("listProduct", listProduct);

		List<Product> listProductNew = productDAO.getNewProduct();
		request.setAttribute("listProductNew", listProductNew);
		
		request.setAttribute("maintitle", "Tất cả sản phẩm");

		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
