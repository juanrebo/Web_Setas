package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Division;
import com.setas.modelo.Subdivision;
import com.setas.service.ServiceSubdivision;
import com.setas.service.ServiceSubdivisionImp;
import com.setas.util.Accion;

public class EliminarSubdivisionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSubdivision ss = new ServiceSubdivisionImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			Integer idsubdivision = Integer.parseInt(parametro.substring(8, parametro.length()));
			Subdivision subdivision = ss.recuperaSubdivision(idsubdivision);
			ss.eliminarSubdivision(subdivision);
		}
		Division division = (Division) request.getSession().getAttribute("division");
		return "subdivision.do"+division.getIddivision().toString();
	}

}
