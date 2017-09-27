package com.petInformation.model;

import java.util.List;

public interface PetInformationDao_interface {

	public Integer insert(PetInformationVO informationVO);
	
	public void update(PetInformationVO informationVO);
	
	public void delete(Integer petNo);
	
	public PetInformationVO findByPK(Integer petNo);
	
	public List<PetInformationVO> getAll();
	
	public List<PetInformationVO> getSupplyPet (Integer memNo);  //一對多：某會員送養了幾隻動物, 回傳幾隻動物
	
}
