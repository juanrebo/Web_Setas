package com.setas.accionClasificacion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Genero;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.util.Accion;

public class InsertarGeneroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceGenero sg = new ServiceGeneroImp();
			Familia familia = (Familia) request.getSession().getAttribute("familia");
			Genero genero = new Genero();
			genero.setGenero(request.getParameter("nuevoGenero"));
			genero.setFamilia(familia);
			sg.insertarGenero(genero);
			
			List<Genero> listaGenero = (List<Genero>) sg.getGenero();
			request.getSession().setAttribute("listaGenero", listaGenero);
			return "genero.do?familia="+familia.getFamilia().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
