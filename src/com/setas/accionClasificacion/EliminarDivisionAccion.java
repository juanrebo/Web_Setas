package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Division;
import com.setas.service.ServiceDivision;
import com.setas.service.ServiceDivisionImp;
import com.setas.util.Accion;

public class EliminarDivisionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceDivision sd = new ServiceDivisionImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			Integer iddivision = Integer.parseInt(parametro.substring(8, parametro.length()));
			Division division = sd.recuperaDivision(iddivision);
			sd.eliminarDivision(division);
		}
		return "division.do";
	}

}
