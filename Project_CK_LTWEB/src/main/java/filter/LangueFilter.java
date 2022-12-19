package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LangueFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest rq = (HttpServletRequest)request;
		rq.setCharacterEncoding("utf-8");
		String lang = request.getParameter("lang");
		String getLang = (String)rq.getSession().getAttribute("langName");
		if(lang != null ) {
			rq.getSession().setAttribute("langName", lang);
		}else if(getLang == null) {
			rq.getSession().setAttribute("langName", "vi_VN");
		}
		chain.doFilter(request, response);
		
	}

}
