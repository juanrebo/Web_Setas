package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.util.Accion;

public class FiloAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFilo sf = new ServiceFiloImp();
		request.getSession().setAttribute("listaFilo", sf.getFilo());

		if(request.getRequestURI().equals("/Web_Setas/filo.do")) {
			return "/filo.jsp";
		}else {
			return "REDIRECT ../filo.jsp";
		}
	}

}
