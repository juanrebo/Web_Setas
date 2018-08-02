package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.modelo.Orden;
import com.setas.service.ServiceOrden;
import com.setas.service.ServiceOrdenImp;
import com.setas.util.Accion;

public class EliminarOrdenAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceOrden so = new ServiceOrdenImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String orden = parametro.substring(8, parametro.length());
			Orden unOrden = so.recuperaOrden(orden);
			so.eliminarOrden(unOrden);
		}
		Clase clase = (Clase) request.getSession().getAttribute("clase");
		return "orden.do?clase="+clase.getClase().toString();
	}

}
