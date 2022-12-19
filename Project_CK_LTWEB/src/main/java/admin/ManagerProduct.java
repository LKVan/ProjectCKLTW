package admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ManagerProduct
 */
@MultipartConfig
@WebServlet("/manager_product")
public class ManagerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductDAO productDAO = new ProductDAO();
		CategoryDAO cateDAO = new CategoryDAO();
		HashMap<String,String> message = new HashMap<>();

		List<Product> listProduct = productDAO.getAllProduct();
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("message", message);
		String action = request.getParameter("action");
		String update = request.getParameter("update");
		String add = request.getParameter("add");
		String access = request.getParameter("access");
		
		if(access != null) {
			request.setAttribute("access", access);
		}

		if (action != null) {
			if (action.equals("edit")) {
				action = "";
				String proId = request.getParameter("proId");
				System.out.println(proId);
				Product product = productDAO.getProductById(Integer.parseInt(proId));
				List<Category> listCate = cateDAO.getAllCategory();
				
				request.setAttribute("product", product);
				request.setAttribute("listCate", listCate);
				request.getRequestDispatcher("/admin/productEdit.jsp").forward(request, response);
				return;
			} else if (action.equals("trash")) {
				String proId = request.getParameter("proId");
				String path = "D:\\Web\\Project_CK\\Project_CK\\Project_CK_LTWEB\\src\\main\\webapp\\";

				Product product = productDAO.getProductById(Integer.parseInt(proId));
				path = path + product.getImage();
				File file = new File(path);
				file.delete();

				productDAO.delete(product.getId());
				//message.put("success", "Xoá thành công");
				response.sendRedirect("/Project_CK_LTWEB/manager_product");
			} else if (action.equals("add")) {
				List<Category> listCate = cateDAO.getAllCategory();
				request.setAttribute("listCate", listCate);
				request.getRequestDispatcher("/admin/addProduct1.jsp").forward(request, response);
				return;
			}
			return;

		} else if (update != null) {
			String proId = request.getParameter("productId");
			String proName = request.getParameter("productName");
			String proImage = request.getParameter("productImage");
			String proDes = request.getParameter("productDes");
			String proPrice = request.getParameter("productPrice");
			String proKind = request.getParameter("productKind");
			System.out.println("id"+proId + "name"+proName +"img"+proImage +"des"+proDes + "price"+proPrice +"kind"+proKind);

			String upLoadFolder = "C:\\Users\\van06\\Downloads\\";
			Path upLoadPath = Paths.get(upLoadFolder);
			Part image = request.getPart("uploadImage");

			String imageFileName = Path.of(image.getSubmittedFileName()).getFileName().toString();

			if (imageFileName != null && !imageFileName.equals("")) {
				File file = new File(upLoadFolder + File.separator + imageFileName);
				System.out.println(file.getAbsolutePath());
				if (!file.exists()) {
					File deleteFile = new File("C:\\Users\\van06\\Downloads\\" + proImage);
					proImage = "Image/" + imageFileName;
					image.write(Paths.get(upLoadPath.toString(), imageFileName).toString());
					deleteFile.delete();
				} else {
					Product product = productDAO.getProductById(Integer.parseInt(proId));
					List<Category> listCate = cateDAO.getAllCategory();

					request.setAttribute("product", product);
					request.setAttribute("listCate", listCate);
					request.setAttribute("imageError", "File đã tồn tại");
					update = null;
					request.getRequestDispatcher("/admin/productEdit.jsp").forward(request, response);

					return;
				}
			}
			Product product = new Product(Integer.parseInt(proId), proName, proDes, Integer.parseInt(proPrice),
					proImage, Integer.parseInt(proKind));
			productDAO.update(product);
			response.sendRedirect("/Project_CK_LTWEB/manager_product?access=yes");

		} else if (add != null) {

			List<Category> listCate = cateDAO.getAllCategory();

			String proName = request.getParameter("productName");
			String proImage = request.getParameter("productImage");
			String proDes = request.getParameter("productDes");
			String proPrice = request.getParameter("productPrice");
			String proKind = request.getParameter("productKind");

			String upLoadFolder = "C:\\Users\\van06\\Downloads\\";
			Path upLoadPath = Paths.get(upLoadFolder);
			Part image = request.getPart("uploadImage");

			String imageFileName = Path.of(image.getSubmittedFileName()).getFileName().toString();

			if (imageFileName != null && !imageFileName.equals("")) {
				File file = new File(upLoadFolder + File.separator + imageFileName);
				if (!file.exists()) {
					proImage = "Image/" + imageFileName;
					System.out.println(Paths.get(upLoadPath.toString(), imageFileName).toString());
					image.write(Paths.get(upLoadPath.toString(), imageFileName).toString());
					productDAO.insert(proName, proDes, Integer.parseInt(proPrice), proImage, Integer.parseInt(proKind));
					response.sendRedirect("/Project_CK_LTWEB/manager_product?access=yes");
				} else {
					request.setAttribute("listCate", listCate);
					request.setAttribute("imageError", "File đã tồn tại");
					add = null;
					request.getRequestDispatcher("/admin/addProduct1.jsp").forward(request, response);
					return;
				}
				
				//request.getRequestDispatcher("/manager_product").forward(request, response);
			} else {
				request.setAttribute("listCate", listCate);
				request.setAttribute("imageError", "Vui lòng chọn File");
				request.getRequestDispatcher("/admin/addProduct1.jsp").forward(request, response);
			}

		}

		else
			request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
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
