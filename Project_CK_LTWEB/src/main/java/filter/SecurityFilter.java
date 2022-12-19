package filter;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebFilter("/admin/*")
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String uri = rq.getRequestURI();
		User user = (User) rq.getSession().getAttribute("user");
		String error = "";

		if (user == null) {
			error = resp.encodeURL("Vui lòng đăng nhập");
		} else if (user.getRolId() != 1 && uri.contains("/amin/")) {
			error = resp.encodeURL("Vui lòng đăng nhập với vai trò admin");
		}

		if (!error.isEmpty()) {
			rq.setAttribute("securi", uri);
			resp.sendRedirect("/Project_CK_LTWEB/login?error=" + resp.encodeURL(error));
		} else {
			chain.doFilter(rq, resp);
		}

	}

}
