package com.setas.accionLocalizacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Localizacion;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceLocalizacion;
import com.setas.service.ServiceLocalizacionImp;
import com.setas.util.Accion;

public class EliminarLocalizacionAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceLocalizacion sl = new ServiceLocalizacionImp();
		int idlocalizacion = Integer.parseInt(request.getParameter("idlocalizacion"));
		Localizacion localizacion = sl.recuperarLocalizacion(idlocalizacion);
		sl.eliminarLocalizacion(localizacion);
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		request.getSession().setAttribute("listaLocalizacion", sl.recuperarLocalizaUsu(usuario));
		
		return "Mapa.jsp";
	}

}
