package com.PetImage.model;

import java.util.List;

public interface PetImageDao_interface {

	public void insert(PetImageVO imageVO);  
	public void update(PetImageVO imageVO); 
	public void delete(Integer picNo);  
	public PetImageVO findByPK(Integer picNo);  
	public List<PetImageVO> getAll();    
	public List<PetImageVO> getPetPic(Integer petNo);  //用一隻動物去查多張圖
		
}
