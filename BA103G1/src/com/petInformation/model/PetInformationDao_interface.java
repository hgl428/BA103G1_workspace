package com.petInformation.model;

import java.util.List;

public interface PetInformationDao_interface {

	public void insert(PetInformationVO informationVO);
	
	public void update(PetInformationVO informationVO);
	
	public void delete(Integer petNo);
	
	public PetInformationVO findByPK(Integer petNo);
	
	public List<PetInformationVO> getAll();
	
}
