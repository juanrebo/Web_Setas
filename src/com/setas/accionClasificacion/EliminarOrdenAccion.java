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
		try {
			ServiceOrden so = new ServiceOrdenImp();
			String orden = request.getParameter("actual");
			Orden unOrden = so.recuperaOrden(orden);
			so.eliminarOrden(unOrden);
			
			Clase clase = (Clase) request.getSession().getAttribute("clase");
			return "orden.do?clase="+clase.getClase().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
