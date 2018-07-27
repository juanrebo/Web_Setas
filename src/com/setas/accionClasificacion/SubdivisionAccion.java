package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Division;
import com.setas.service.ServiceDivision;
import com.setas.service.ServiceDivisionImp;
import com.setas.service.ServiceSubdivision;
import com.setas.service.ServiceSubdivisionImp;
import com.setas.util.Accion;

public class SubdivisionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceDivision sd = new ServiceDivisionImp();
		int iddivision = Integer.parseInt(request.getParameter("division"));
		Division division = sd.recuperaDivision(iddivision);
		request.getSession().setAttribute("division", division);
		
		ServiceSubdivision ss = new ServiceSubdivisionImp();
		request.getSession().setAttribute("listaSubdivision", ss.getSubdivisonDivision(division.getIddivision()));
		
		return "subdivision.jsp";
	}

}
