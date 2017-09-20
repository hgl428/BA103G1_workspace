package com.PetSpecies.model;

import java.util.List;

import com.PetSpecies.model.PetSpeciesVO;

public interface PetSpeciesDao_interface {
	public void insert(PetSpeciesVO petSpecies);
	public void update(PetSpeciesVO petSpecies);
	public void delete(Integer SpeciesNo);
	public PetSpeciesVO findByPK(Integer SpeciesNo);
	public List<PetSpeciesVO> getAll();
//	public PetSpeciesVO findByBreed(Integer speciesNo);
}
