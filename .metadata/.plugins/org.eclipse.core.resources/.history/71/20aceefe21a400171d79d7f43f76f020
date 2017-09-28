package com.PetView.model;

import java.util.List;
import java.util.Map;

import com.petInformation.model.PetInformationVO;




public class PetViewService {
	
	private PetViewDao_interface dao;
	
	public PetViewService() {
		dao = new PetViewDao();
//		dao = new PetInformationDaoJDBC();
	}
	
	
	public List<PetViewVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);

	}
	public List<PetViewVO> getAll(){
		return dao.getAll();
	}
	public PetViewVO getOnePet(Integer petNo) {
		return dao.findByPetNo(petNo);
	}
}
