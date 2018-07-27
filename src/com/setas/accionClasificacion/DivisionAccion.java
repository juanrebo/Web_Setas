package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.service.ServiceDivision;
import com.setas.service.ServiceDivisionImp;
import com.setas.util.Accion;

public class DivisionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceDivision sd = new ServiceDivisionImp();
		request.getSession().setAttribute("listaDivision", sd.getDivision());
		
		return "division.jsp";
	}

}
