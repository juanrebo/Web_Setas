package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Filo;
import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.util.Accion;

public class EliminarFiloAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFilo sf = new ServiceFiloImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String filo = parametro.substring(8, parametro.length());
			Filo unFilo = sf.recuperaFilo(filo);
			sf.eliminarFilo(unFilo);
		}
		return "filo.do";
	}

}
