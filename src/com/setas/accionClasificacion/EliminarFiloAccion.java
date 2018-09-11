package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Filo;
import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.util.Accion;

public class EliminarFiloAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceFilo sf = new ServiceFiloImp();
			String filo = request.getParameter("actual");
			Filo unFilo = sf.recuperaFilo(filo);
			sf.eliminarFilo(unFilo);
			return "filo.do";
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}

}
