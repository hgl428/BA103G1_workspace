package com.adoptionList.model;

import java.util.List;

public class AdoptionService {

	private AdoptionListDao_interface dao;
	
	public AdoptionService(){
		dao = new AdoptionListDao();
	}
	//提交領養某隻動物
	public  AdoptionListVO apply(Integer memNo, Integer petNo,Integer supplyMen){
		AdoptionListVO adoptVO = new AdoptionListVO();
		
		adoptVO.setMemNo(memNo);
		adoptVO.setPetNo(petNo);
		adoptVO.setSupplyMen(supplyMen);
	
		dao.insert(adoptVO);
		return adoptVO;
	}
	//對某隻動物取消認養
	public void delete(Integer memNo, Integer petNo){
		 dao.delete(memNo, petNo);    
	}
	
	// 領養人對幾隻動物提出申請，回傳全部的動物
	public List<AdoptionListVO> getApplyPet(Integer memNo){
		return dao.getApplyPet(memNo);
	}
	//確認最終領養人，將所有的領養請求做刪除
	public void deleteAllApply(Integer petNo){
		dao.deleteAllApplyPet(petNo);
	}
	
	//一隻動物有多少領養人
	public List<AdoptionListVO> getPetApply(Integer petNo){
		return dao.getApplyPet(petNo);
	}
}

