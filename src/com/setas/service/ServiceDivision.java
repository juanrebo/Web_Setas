package com.setas.service;

import java.util.List;

import com.setas.modelo.Division;

public interface ServiceDivision {
	public void insertarDivision(Division division);
	public List<Division> getDivision();
	public void modificarDivision(Division division);
	public void eliminarDivision(Division division);
}
