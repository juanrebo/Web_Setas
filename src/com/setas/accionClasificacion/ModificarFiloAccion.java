package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Filo;
import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.util.Accion;

public class ModificarFiloAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFilo sf = new ServiceFiloImp();
		String filo = request.getParameter("actual");
		Filo unFilo = sf.recuperaFilo(filo);
		String nuevoFilo = request.getParameter("nuevo");
		unFilo.setFilo(nuevoFilo);
		sf.modificarFilo(unFilo);
		return "filo.do";
	}
}