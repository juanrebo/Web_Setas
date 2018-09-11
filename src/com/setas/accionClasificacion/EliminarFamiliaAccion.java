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
		try {
			ServiceFamilia sf = new ServiceFamiliaImp();
			String familia = request.getParameter("actual");
			Familia unaFamilia = sf.recuperaFamilia(familia);
			sf.eliminarFamilia(unaFamilia);
			
			Orden orden = (Orden) request.getSession().getAttribute("orden");
			return "familia.do?orden="+orden.getOrden().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}

}
