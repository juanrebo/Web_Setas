package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.service.ServiceClase;
import com.setas.service.ServiceClaseImp;
import com.setas.service.ServiceOrden;
import com.setas.service.ServiceOrdenImp;
import com.setas.util.Accion;

public class OrdenAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceClase sc = new ServiceClaseImp();
		String clase = request.getParameter("clase");
		Clase unaClase = sc.recuperaClase(clase);
		request.getSession().setAttribute("clase", unaClase);
		
		ServiceOrden so = new ServiceOrdenImp();
		request.getSession().setAttribute("listaOrden", so.getOrdenClase(unaClase));
		
		return "orden.jsp";
	}
}
