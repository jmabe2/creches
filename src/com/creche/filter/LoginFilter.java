package com.creche.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	
	FilterConfig fc;
	
	public void init (FilterConfig filterConfig) throws ServletException{
		fc = filterConfig;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		String pageRequested = req.getRequestURL().toString();
		
		if (session.getAttribute("personnel") == null && 
				!pageRequested.contains("index.xhtml")){
			resp.sendRedirect("index.xhtml");
		} else{
			chain.doFilter(request, response);
		}
	}
	
	public void destroy(){
		
	}
}