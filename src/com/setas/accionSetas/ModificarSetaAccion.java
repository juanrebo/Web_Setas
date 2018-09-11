package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Foto;
import com.setas.modelo.Genero;
import com.setas.modelo.Nombre;
import com.setas.modelo.Seta;
import com.setas.service.ServiceFoto;
import com.setas.service.ServiceFotoImp;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceNombre;
import com.setas.service.ServiceNombreImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class ModificarSetaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSeta ss = new ServiceSetaImp();
		Seta seta = (Seta) request.getSession().getAttribute("seta");
		
		ServiceGenero sg = new ServiceGeneroImp();
		String generoNuevo = request.getParameter("generoNuevo");
		Genero nuevoGenero = sg.recuperaGenero(generoNuevo);
		seta.setGenero(nuevoGenero);
		request.getSession().setAttribute("genero", nuevoGenero);
		
		seta.getId().setEspecie(request.getParameter("especie"));
		seta.setCuerpoFructifero(request.getParameter("cuerpoFructifero"));
		seta.setSombrero(request.getParameter("sombrero"));
		seta.setHimenio(request.getParameter("himenio"));
		seta.setGleba(request.getParameter("gleba"));
		seta.setEstroma(request.getParameter("estroma"));
		seta.setCarne(request.getParameter("carne"));
		seta.setLaminas(request.getParameter("laminas"));
		seta.setTubos(request.getParameter("tubos"));
		seta.setPie(request.getParameter("pie"));
		seta.setCarne(request.getParameter("carne"));
		seta.setEsporas(request.getParameter("esporas"));
		seta.setHabitat(request.getParameter("habitat"));
		seta.setComestibilidad(request.getParameter("comestibilidad"));
		
		String ruta = request.getParameter("ruta");
		if(ruta != "") {
			ServiceFoto sf = new ServiceFotoImp();
			String derecho = request.getParameter("derecho");
			List<Foto> listaFotos = sf.recuperaFoto(seta);
			Foto foto = new Foto();
			Boolean existe = false;
			for(Foto f:listaFotos) {
				if(f.getRuta().equals(ruta)) {
					existe = true;
					f.setSeta(seta);
					f.setDerecho(derecho);
					sf.modificarFoto(f);
				}
			}
			if(!existe) {
				foto.setRuta(ruta);
				foto.setSeta(seta);
				foto.setDerecho(derecho);
				sf.insertarFoto(foto);
			}
		}
		
		String nombrereq = request.getParameter("nombre");
		if(nombrereq != "") {
			String idiomareq = request.getParameter("idioma");
			Nombre nombre = new Nombre();
			nombre.setIdioma(idiomareq);
			nombre.setNombre(nombrereq);
			nombre.setSeta(seta);
			ServiceNombre sn = new ServiceNombreImp();
			sn.insertarNombre(nombre);
		}
		
		ss.modificarSeta(seta);
		
		return "REDIRECT ../seta.do?genero="+seta.getGenero().getGenero()+"&especie="+seta.getId().getEspecie();
	}

}
