package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Division;
import com.setas.service.ServiceDivision;
import com.setas.service.ServiceDivisionImp;
import com.setas.util.Accion;

public class InsertarDivisionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceDivision sd = new ServiceDivisionImp();
		Division division = new Division();
		division.setDivision(request.getParameter("nuevaDivision"));
		sd.insertarDivision(division);
		return "division.do";
	}

}
