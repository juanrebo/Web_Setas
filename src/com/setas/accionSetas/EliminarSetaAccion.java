package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Seta;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class EliminarSetaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSeta ss = new ServiceSetaImp();
		Seta seta = (Seta) request.getSession().getAttribute("seta");
		ss.eliminarSeta(seta);
		
		List<Seta> todasSetas = ss.getSeta();
		request.getServletContext().setAttribute("todasSetas", todasSetas);
		return "REDIRECT ../setas.jsp";
	}

}
