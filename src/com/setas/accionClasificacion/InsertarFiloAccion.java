package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Filo;
import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.util.Accion;

public class InsertarFiloAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFilo sf = new ServiceFiloImp();
		Filo filo = new Filo();
		filo.setFilo(request.getParameter("nuevoFilo"));
		sf.insertarFilo(filo);
		return "filo.do";
	}

}
