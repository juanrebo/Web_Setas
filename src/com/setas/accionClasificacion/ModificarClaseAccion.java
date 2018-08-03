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
		ServiceClase sc = new ServiceClaseImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String clase = parametro.substring(9, parametro.length());
			String nuevaClase = request.getParameter("modificar"+clase);
			Clase unaClase = sc.recuperaClase(clase);
			unaClase.setClase(nuevaClase);
			sc.modificarClase(unaClase);
		}
		Filo filo = (Filo) request.getSession().getAttribute("filo");
		return "clase.do?filo="+filo.getFilo().toString();
	}

}
