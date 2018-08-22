package com.setas.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Rol;

/**
 * Servlet Filter implementation class FiltroLog
 */
@WebFilter("/FiltroLog")
public class FiltroLog implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLog() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean autorizado = false;
		String url = req.getServletPath();
		
		if(req.getSession().getAttribute("usuario")==null)
			res.sendRedirect(req.getContextPath()+"/login.html");
		else {
			Rol rol = (Rol) req.getSession().getAttribute("rol");
			if(url.contains(rol.getRol()))
				autorizado = true;
			if(autorizado)
				chain.doFilter(request, response);
			else
				res.sendRedirect(req.getContextPath()+"/noautorizado.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
