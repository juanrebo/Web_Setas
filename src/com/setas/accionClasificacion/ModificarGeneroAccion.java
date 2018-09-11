package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Genero;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.util.Accion;

public class ModificarGeneroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceGenero sg = new ServiceGeneroImp();
			String genero = request.getParameter("actual");
			Genero unGenero = sg.recuperaGenero(genero);
			String nuevoGenero = request.getParameter("nuevo");
			unGenero.setGenero(nuevoGenero);
			sg.modificarGenero(unGenero);
			
			Familia familia = (Familia) request.getSession().getAttribute("familia");
			return "genero.do?familia="+familia.getFamilia().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
