package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Clase;
import com.setas.modelo.Familia;
import com.setas.modelo.Filo;
import com.setas.modelo.Foto;
import com.setas.modelo.Genero;
import com.setas.modelo.Orden;
import com.setas.modelo.Seta;
import com.setas.service.ServiceClase;
import com.setas.service.ServiceClaseImp;
import com.setas.service.ServiceFamilia;
import com.setas.service.ServiceFamiliaImp;
import com.setas.service.ServiceFilo;
import com.setas.service.ServiceFiloImp;
import com.setas.service.ServiceFoto;
import com.setas.service.ServiceFotoImp;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceOrden;
import com.setas.service.ServiceOrdenImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class SetaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceGenero sge = new ServiceGeneroImp();
		ServiceFamilia sfa = new ServiceFamiliaImp();
		ServiceOrden sor = new ServiceOrdenImp();
		ServiceClase scl = new ServiceClaseImp();
		ServiceFilo sfi = new ServiceFiloImp();
		
		String generoString = request.getParameter("genero");
		Genero genero = sge.recuperaGenero(generoString);
		Familia familia = sfa.recuperaFamilia(genero.getFamilia().getFamilia());
		Orden orden = sor.recuperaOrden(familia.getOrden().getOrden());
		Clase clase = scl.recuperaClase(orden.getClase().getClase());
		Filo filo = sfi.recuperaFilo(clase.getFilo().getFilo());
		
		int idgenero = genero.getIdgenero();
		ServiceSeta ss = new ServiceSetaImp();
		String especie = request.getParameter("especie");
		Seta unaSeta = ss.recuperaSeta(idgenero, especie);
		request.getSession().setAttribute("seta", unaSeta);
		request.getSession().setAttribute("genero", genero);
		request.getSession().setAttribute("familia", familia);
		request.getSession().setAttribute("orden", orden);
		request.getSession().setAttribute("clase", clase);
		request.getSession().setAttribute("filo", filo);
		
		ServiceFoto sf = new ServiceFotoImp();
		List<Foto> listaFotos = null;
		listaFotos = (List<Foto>) sf.recuperaFoto(unaSeta.getIdseta());
		if(!listaFotos.isEmpty()) {
			request.setAttribute("listaFotos", listaFotos);
		}
		
		return "seta.jsp";
	}

}
