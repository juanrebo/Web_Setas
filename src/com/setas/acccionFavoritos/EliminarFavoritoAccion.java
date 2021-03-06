package com.setas.acccionFavoritos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Favorito;
import com.setas.modelo.FavoritoId;
import com.setas.modelo.Seta;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceFavorito;
import com.setas.service.ServiceFavoritoImp;
import com.setas.util.Accion;

public class EliminarFavoritoAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		Seta seta = (Seta) request.getSession().getAttribute("seta");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		FavoritoId favoritoid = new FavoritoId(usuario.getIdusuario(),seta.getIdseta());
		Favorito favorito = new Favorito(favoritoid, seta, usuario);
		
		ServiceFavorito sf = new ServiceFavoritoImp();
		sf.eliminarFavorito(favorito);
		request.getSession().setAttribute("listaFavorito", sf.recuperaFavoritos(usuario));
		
		return "seta.jsp";
	}

}
