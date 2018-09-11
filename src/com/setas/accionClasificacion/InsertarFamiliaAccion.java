package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Orden;
import com.setas.service.ServiceFamilia;
import com.setas.service.ServiceFamiliaImp;
import com.setas.util.Accion;

public class InsertarFamiliaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceFamilia sf = new ServiceFamiliaImp();
			Orden orden = (Orden) request.getSession().getAttribute("orden");
			Familia familia = new Familia();
			familia.setFamilia(request.getParameter("nuevaFamilia"));
			familia.setOrden(orden);
			sf.insertarFamilia(familia);
			return "familia.do?orden="+orden.getOrden().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
