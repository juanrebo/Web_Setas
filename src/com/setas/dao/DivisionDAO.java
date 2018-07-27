package com.setas.dao;

import java.util.List;

import com.setas.modelo.Division;

public interface DivisionDAO {
	public void insertarDivision(Division division);
	public List<Division> getDivision();
	public void modificarDivision(Division division);
	public void eliminarDivision(Division division);
	public Division recuperaDivision(int iddivision);
}
