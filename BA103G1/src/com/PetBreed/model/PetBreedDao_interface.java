package com.PetBreed.model;

import java.util.List;



public interface PetBreedDao_interface {
	
	public void insert(PetBreedVO breed);
	public void update(PetBreedVO breed);
	public void delete(Integer breedNo);
	public PetBreedVO findOneByPK(Integer breedNo);
	public List<PetBreedVO> getAll();
//	public PetBreedVO findByPet(Integer breedNo);
}
