package com.PetImage.model;

import java.util.List;

public interface PetImageDao_interface {

	public void insert(PetImageVO imageVO);  //新增
	public void update(PetImageVO imageVO);  //修改
	public void delete(Integer picNo);  //刪除
	public PetImageVO findByPK(Integer picNo);  //用 pk查一個動物
	public List<PetImageVO> getAll();    //查全部
	
		
}
