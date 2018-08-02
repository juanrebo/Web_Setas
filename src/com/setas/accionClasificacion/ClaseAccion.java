package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Filo;
import com.setas.service.ServiceClase;
import com.setas.service.ServiceClaseImp;
import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.util.Accion;

public class ClaseAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFilo sd = new ServiceFiloImp();
		String filo = request.getParameter("filo");
		Filo unFilo = sd.recuperaFilo(filo);
		request.getSession().setAttribute("filo", unFilo);
		
		ServiceClase sc = new ServiceClaseImp();
		request.getSession().setAttribute("listaClase", sc.getClaseFilo(unFilo));
		
		return "clase.jsp";
	}

}
