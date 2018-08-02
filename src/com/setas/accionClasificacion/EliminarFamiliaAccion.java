package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Orden;
import com.setas.service.ServiceFamilia;
import com.setas.service.ServiceFamiliaImp;
import com.setas.util.Accion;

public class EliminarFamiliaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFamilia sf = new ServiceFamiliaImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String familia = parametro.substring(8, parametro.length());
			Familia unaFamilia = sf.recuperaFamilia(familia);
			sf.eliminarFamilia(unaFamilia);
		}
		Orden orden = (Orden) request.getSession().getAttribute("orden");
		return "familia.do?orden="+orden.getOrden().toString();
	}

}
