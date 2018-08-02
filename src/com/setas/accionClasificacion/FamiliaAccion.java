package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Orden;
import com.setas.service.ServiceFamilia;
import com.setas.service.ServiceFamiliaImp;
import com.setas.service.ServiceOrden;
import com.setas.service.ServiceOrdenImp;
import com.setas.util.Accion;

public class FamiliaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceOrden so = new ServiceOrdenImp();
		String orden = request.getParameter("orden");
		Orden unOrden = so.recuperaOrden(orden);
		request.getSession().setAttribute("orden", unOrden);
		
		ServiceFamilia sf = new ServiceFamiliaImp();
		request.getSession().setAttribute("listaFamilia", sf.getFamiliaOrden(unOrden));
		
		return "familia.jsp";
	}

}
