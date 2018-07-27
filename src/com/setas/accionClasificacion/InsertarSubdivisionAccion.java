package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Division;
import com.setas.modelo.Subdivision;
import com.setas.service.ServiceSubdivision;
import com.setas.service.ServiceSubdivisionImp;
import com.setas.util.Accion;

public class InsertarSubdivisionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSubdivision ss = new ServiceSubdivisionImp();
		Division division = (Division) request.getSession().getAttribute("division");
		Subdivision subdivision = new Subdivision();
		subdivision.setSubdivision(request.getParameter("nuevaSubdivision"));
		subdivision.setDivision(division);
		ss.insertarSubdivision(subdivision);
		return "subdivision.do?division="+division.getIddivision().toString();
	}

}
