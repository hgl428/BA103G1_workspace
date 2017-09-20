package com.PetImage.model;

import java.util.List;

public interface PetImageDao_interface {

	public void insert(PetImageVO imageVO);  //�s�W
	public void update(PetImageVO imageVO);  //�ק�
	public void delete(Integer picNo);  //�R��
	public PetImageVO findByPK(Integer picNo);  //�� pk�d�@�Ӱʪ�
	public List<PetImageVO> getAll();    //�d����
	
		
}
