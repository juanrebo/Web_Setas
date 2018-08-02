package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.modelo.Filo;
import com.setas.service.ServiceClase;
import com.setas.service.ServiceClaseImp;
import com.setas.util.Accion;

public class EliminarClaseAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceClase sc = new ServiceClaseImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String clase = parametro.substring(8, parametro.length());
			Clase unaClase = sc.recuperaClase(clase);
			sc.eliminarClase(unaClase);
		}
		Filo filo = (Filo) request.getSession().getAttribute("filo");
		return "clase.do?filo="+filo.getFilo().toString();
	}

}
