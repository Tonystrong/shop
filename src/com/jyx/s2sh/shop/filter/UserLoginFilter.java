package com.jyx.s2sh.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if (request.getSession().getAttribute("user")==null) {
			String url = request.getServletPath();
			String param = request.getQueryString();
			if (param!=null) {
				url = url+ "?" +param;
			}
			request.getSession().setAttribute("nextUrl", url);
			request.getSession().setAttribute("error", "非法访问请登陆!");
			response.sendRedirect(request.getContextPath()+ "/ulogin.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	

}
