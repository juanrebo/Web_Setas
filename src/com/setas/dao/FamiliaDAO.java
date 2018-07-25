package com.setas.dao;

import java.util.List;

import com.setas.modelo.Familia;
import com.setas.modelo.Orden;

public interface FamiliaDAO {
	public void insertarFamilia(Familia familia);
	public List<Familia> getFamilia();
	public List<Familia> getFamiliaOrden(Orden orden);
	public void modificarFamilia(Familia familia);
	public void eliminarFamilia(Familia familia);
}
