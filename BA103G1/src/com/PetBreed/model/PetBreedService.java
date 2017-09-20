package com.PetBreed.model;

import java.util.List;

public class PetBreedService {
	private PetBreedDao_interface dao;

	public PetBreedService() {
		dao = new PetBreedDao();
	}

	public PetBreedVO addPetBreed(Integer speciesNo) {

		PetBreedVO breedVO = new PetBreedVO();

		
		
		breedVO.setSpeciesNo(speciesNo);

		dao.insert(breedVO);

		return breedVO;
	}

	public PetBreedVO updatePetBreed(Integer breedNo, String breedName, Integer speciesNo) {

		PetBreedVO breedVO = new PetBreedVO();

		breedVO.setBreedNo(breedNo);
		breedVO.setBreedName(breedName);
		breedVO.setSpeciesNo(speciesNo);

		dao.update(breedVO);

		return breedVO;
	}

	public void deletePetBreed(Integer breedNo) {

		dao.delete(breedNo);

	}

	public PetBreedVO getOneBreed(Integer breedNo) {

		return dao.findOneByPK(breedNo);

	}
	
	public List<PetBreedVO> getAll(){
		return dao.getAll();
	}

}
