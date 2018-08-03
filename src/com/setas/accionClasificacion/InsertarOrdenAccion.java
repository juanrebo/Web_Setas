package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.modelo.Orden;
import com.setas.service.ServiceOrden;
import com.setas.service.ServiceOrdenImp;
import com.setas.util.Accion;

public class InsertarOrdenAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceOrden so = new ServiceOrdenImp();
		Clase clase = (Clase) request.getSession().getAttribute("clase");
		Orden orden = new Orden();
		orden.setOrden(request.getParameter("nuevoOrden"));
		orden.setClase(clase);
		so.insertarOrden(orden);
		return "orden.do?clase="+clase.getClase().toString();
	}

}
