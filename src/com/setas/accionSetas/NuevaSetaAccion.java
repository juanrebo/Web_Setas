package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.util.Accion;

public class NuevaSetaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceGenero sg = new ServiceGeneroImp();
		List<Genero> todoGenero = (List<Genero>) sg.getGenero();
		request.setAttribute("todoGenero", todoGenero);
		return "admin/InsertarSeta.jsp";
	}

}
