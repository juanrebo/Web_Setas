package com.setas.dao;

import java.util.List;

import com.setas.modelo.Division;
import com.setas.modelo.Familia;
import com.setas.modelo.Subdivision;

public interface SubdivisionDAO {
	public void insertarSubdivision(Subdivision subdivision);
	public List<Subdivision> getSubdivision();
	public List<Subdivision> getSubdivisonDivision(int division);
	public void modificarSubdivision(Subdivision subdivision);
	public void eliminarSubdivision(Subdivision subdivision);
	public Subdivision recuperaSubdivision(int idsubdivision);
}
