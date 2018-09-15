package com.setas.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.modelo.Seta;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;

/**
 * Servlet implementation class CargaSetas
 */
@WebServlet("/CargaSetas")
public class CargaSetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaSetas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	ServiceSeta ss = new ServiceSetaImp();
		List<Seta> todasSetas = ss.getSeta();
		getServletContext().setAttribute("todasSetas", todasSetas);
		
		ServiceGenero sg = new ServiceGeneroImp();
		List<Genero> todoGenero = (List<Genero>) sg.getGenero();
		getServletContext().setAttribute("todoGenero", todoGenero);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
