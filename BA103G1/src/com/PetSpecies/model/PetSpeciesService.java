package com.PetSpecies.model;

import java.util.List;

import com.petInformation.model.PetInformationVO;

public class PetSpeciesService {  
	
	

	private PetSpeciesDao_interface dao;

	public PetSpeciesService() {
		dao = new PetSpeciesDao();
	}

	public PetSpeciesVO addPetSpecies(Integer SpeciesNo) {
		PetSpeciesVO speciesVO = new PetSpeciesVO();

		speciesVO.setSpeciesNo(SpeciesNo);
		

		dao.insert(speciesVO);

		return speciesVO;
	}

	public PetSpeciesVO updateSpecies(Integer SpeciesNo, String SpeciesName) {
		
		PetSpeciesVO speciesVO = new PetSpeciesVO();
		
		speciesVO.setSpeciesNo(SpeciesNo);
		speciesVO.setSpeciesName(SpeciesName);
		
		dao.update(speciesVO);
		
		return speciesVO;
		
	}
	
	public void deleteSpecies(Integer species){
		dao.delete(species);
		
	}
	public PetSpeciesVO findByPk(Integer speciesNo) {
		return dao.findByPK(speciesNo);
	}

	public List<PetSpeciesVO> getAll() {
		return dao.getAll();

	}
}
