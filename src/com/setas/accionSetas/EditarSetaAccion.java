package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.modelo.Seta;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.util.Accion;

public class EditarSetaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceGenero sg = new ServiceGeneroImp();
		List<Genero> listaGenero = sg.getGenero();
		request.getSession().setAttribute("listaGenero", listaGenero);
		Seta seta = (Seta) request.getSession().getAttribute("seta");
		return "admin/EditarSeta.jsp?genero="+seta.getGenero().getGenero()+"&especie="+seta.getEspecie();
	}
}
