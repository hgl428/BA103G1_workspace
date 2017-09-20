package com.petInformation.model;

import java.sql.Date;
import java.util.List;

public class PetInformationService {

	private PetInformationDao_interface dao;

	public PetInformationService() {
		dao = new PetInformationDao();
	}
	
	public PetInformationVO addPetInfo(Integer memNo, Integer breedNo,String petName,
			String petAge, String petSize, String petColor, String petPosition, String petIc, String TNR,
			String situation, byte[] petFilm, String petTitle, Double petLongitude,
			Double petLatitude,String petSex) {

		PetInformationVO petInfoVO = new PetInformationVO();
		
		petInfoVO.setMemNo(memNo);
		petInfoVO.setBreedNo(breedNo);
		
		petInfoVO.setPetName(petName);
		petInfoVO.setPetAge(petAge);
		petInfoVO.setPetSize(petSize);
		petInfoVO.setPetColor(petColor);
		petInfoVO.setPetPosition(petPosition);
		petInfoVO.setPetIc(petIc);
		petInfoVO.setTNR(TNR);
		petInfoVO.setSituation(situation);
		
		
		petInfoVO.setPetFilm(petFilm);
		petInfoVO.setPetTitle(petTitle);
		petInfoVO.setPetLongitude(petLongitude);
		petInfoVO.setPetLatitude(petLatitude);
		petInfoVO.setPetSex(petSex);

		dao.insert(petInfoVO);

		return petInfoVO;
	}

	public PetInformationVO updatePetInfo(Integer petNo, Integer memNo, Integer breedNo, String status, String petName,
			String petAge, String petSize, String petColor, String petPosition, String petIc, String TNR,
			String situation, Date petDate, Integer memNo2, byte[] petFilm, String petTitle, Double petLongitude,
			Double petLatitude ,String petSex) {

		PetInformationVO petInfo = new PetInformationVO();
		petInfo.setPetNo(petNo);
		petInfo.setMemNo(memNo2);
		petInfo.setBreedNo(breedNo);
		petInfo.setStatus(status);
		petInfo.setPetName(petName);
		petInfo.setPetAge(petAge);
		petInfo.setPetSize(petSize);
		petInfo.setPetColor(petColor);
		petInfo.setPetPosition(petPosition);
		petInfo.setPetIc(petIc);
		petInfo.setTNR(TNR);
		petInfo.setSituation(situation);
		petInfo.setPetDate(petDate);
		petInfo.setMemNo2(memNo2);
		petInfo.setPetFilm(petFilm);
		petInfo.setPetTitle(petTitle);
		petInfo.setPetLongitude(petLongitude);
		petInfo.setPetLatitude(petLatitude);
		petInfo.setPetSex(petSex);
		
		dao.update(petInfo);

		return petInfo;

	}

	public void deletePetInfo(Integer petNo) {
		dao.delete(petNo);
	}

	public PetInformationVO getOnePetInfo(Integer petNo) {
		return dao.findByPK(petNo);
	}

	public List<PetInformationVO> getAll() {
		return dao.getAll();

	}
}