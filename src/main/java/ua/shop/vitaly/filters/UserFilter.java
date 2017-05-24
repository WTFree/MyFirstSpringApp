package ua.shop.vitaly.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import ua.shop.vitaly.models.user.User;

public class UserFilter implements Filter{
	
	private List<String> pathFilters = Arrays.asList(new String[]{
				"ProductCard","PRODUCTCARD","productcard","Productcard","AddToCard",
				"RemoveFromCard"
				}
			);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChaine)
			throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		String path = StringUtils.substringAfterLast(uri, "/");
		
		if(!pathFilters.contains(path)){
			filterChaine.doFilter(request, response);
			return;
		}
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		User user = (User) session.getAttribute("user");
		
		if(user!=null){
			filterChaine.doFilter(request, response);
			return;
		}
		((HttpServletResponse)response).sendRedirect("http://localhost:8080/vitaly/ErrorPage.jsp");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}

}
