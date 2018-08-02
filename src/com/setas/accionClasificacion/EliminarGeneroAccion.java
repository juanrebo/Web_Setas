package com.setas.accionClasificacion;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Seta;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class EliminarGeneroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSeta ss = new ServiceSetaImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String genero = parametro.substring(8, parametro.length());
			List<Seta> setas = ss.getSetaGenero(genero);
			for(Seta s : setas) {
				ss.eliminarSeta(s);
			}
		}
		Familia familia = (Familia) request.getSession().getAttribute("familia");
		return "genero.do?familia="+familia.getFamilia().toString();
	}

}
