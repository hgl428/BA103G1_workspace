package com.PetView.model;

import java.util.List;
import java.util.Map;



public interface PetViewDao_interface {

	public PetViewVO findByPetNo(Integer petNo);
	
	public List<PetViewVO> getAll();

	public List<PetViewVO> getAll(Map<String, String[]> map); 
}
