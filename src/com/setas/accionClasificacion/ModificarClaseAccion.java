package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.modelo.Filo;
import com.setas.service.ServiceClase;
import com.setas.service.ServiceClaseImp;
import com.setas.util.Accion;

public class ModificarClaseAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceClase sc = new ServiceClaseImp();
			String clase = request.getParameter("actual");
			Clase unaClase = sc.recuperaClase(clase);
			String nuevaClase = request.getParameter("nuevo");
			unaClase.setClase(nuevaClase);
			sc.modificarClase(unaClase);
			
			Filo filo = (Filo) request.getSession().getAttribute("filo");
			return "clase.do?filo="+filo.getFilo().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
