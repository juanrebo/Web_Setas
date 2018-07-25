package com.setas.dao;

import java.util.List;

import com.setas.modelo.Clase;
import com.setas.modelo.Subclase;

public interface SubclaseDAO {
	public void insertarSubclase(Subclase subclase);
	public List<Subclase> getSubclase();
	public List<Subclase> getSubclaseClase(Clase clase);
	public void modificarSubclase(Subclase subclase);
	public void eliminarSubclase(Subclase subclase);
}
