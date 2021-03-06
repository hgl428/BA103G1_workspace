package com.petInformation.model;

import java.util.List;

public interface PetInformationDao_interface {

	public Integer insert(PetInformationVO informationVO);   //新增某動物資訊
	
	public void update(PetInformationVO informationVO);   //更新某動物資訊
	
	public void delete(Integer petNo);   //刪除某隻動物資料
	
	public PetInformationVO findByPK(Integer petNo);   //尋找某隻動物的資料
	
	public List<PetInformationVO> getAll();  //回傳所有的動物資訊
	
	public List<PetInformationVO> getSupplyPet (Integer memNo);  //一對多：某會員送養了幾隻動物, 回傳幾隻動物
	
	public void comfirm(Integer memNo);   //更新欄位memNo2,確認某會員為最終領養人
}
