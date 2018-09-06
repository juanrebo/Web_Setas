package com.setas.accionLugares;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Lugar;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceLugar;
import com.setas.service.ServiceLugarImp;
import com.setas.util.Accion;

public class InsertarLugarAccion extends Accion{
	
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		Lugar lugar = new Lugar();
		lugar.setLugar(request.getParameter("nuevoLugar"));
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		lugar.setUsuario(usuario);
		
		ServiceLugar sl = new ServiceLugarImp();
		sl.insertarLugar(lugar);
		
		request.getSession().setAttribute("listaLugar", sl.recuperaLugares(usuario));
		
		return "Mapa.jsp";
	}
}
