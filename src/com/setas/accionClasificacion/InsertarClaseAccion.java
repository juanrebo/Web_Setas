package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.modelo.Filo;
import com.setas.service.ServiceClase;
import com.setas.service.ServiceClaseImp;
import com.setas.util.Accion;

public class InsertarClaseAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceClase sc = new ServiceClaseImp();
			Filo filo = (Filo) request.getSession().getAttribute("filo");
			Clase clase = new Clase();
			clase.setClase(request.getParameter("nuevaClase"));
			clase.setFilo(filo);
			sc.insertarClase(clase);
			return "clase.do?filo="+filo.getFilo().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
