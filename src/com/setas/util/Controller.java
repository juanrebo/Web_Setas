package com.setas.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher despachador=null;		
		String url=request.getServletPath();
		String accion;
		
		if(url.contains("admin")) {
			accion = Accion.getAccion(url.substring(7, url.length()-3)).ejecutar(request, response);
		}else if(url.contains("user")) {
			accion = Accion.getAccion(url.substring(6, url.length()-3)).ejecutar(request, response);
		}else {
			accion = Accion.getAccion(url.substring(1, url.length()-3)).ejecutar(request, response);
		}
		
		if(accion.startsWith("REDIRECT")) {
			response.sendRedirect(accion.substring(9));
		}else {
			despachador=request.getRequestDispatcher(accion);
			despachador.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
