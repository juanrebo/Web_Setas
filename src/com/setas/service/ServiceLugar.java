package com.setas.service;

import java.util.List;

import com.setas.modelo.Lugar;
import com.setas.modelo.Usuario;

public interface ServiceLugar {
	public void insertarLugar(Lugar lugar);
	public void eliminarLugar(Lugar lugar);
	public Lugar recuperaLugar(int idlugar);
	public List<Lugar> recuperaLugares(Usuario usuario);
}
