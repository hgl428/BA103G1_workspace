package com.PetImage.model;

import java.util.List;

public class PetImageService {

	private PetImageDao_interface dao;

	public PetImageService() {
		// dao = new PetImageDao();
		dao = new PetImageDaoJDBC();
	}

	public PetImageVO addPetImage(Integer petNo, byte[] petPicture, String picName) {

		PetImageVO imageVO = new PetImageVO();

		imageVO.setPetNo(petNo);
		imageVO.setpetPicture(petPicture);
		imageVO.setPicName(picName);

		dao.insert(imageVO);
		return imageVO;

	}

	public PetImageVO updatePetImage(byte[] picture, String picName) {
		PetImageVO imageVO = new PetImageVO();

		imageVO.setpetPicture(picture);
		imageVO.setPicName(picName);

		dao.update(imageVO);

		return imageVO;
	}

	public void deletePetImage(Integer picNo) {
		dao.delete(picNo);
	}

	public PetImageVO getOnePetImage(Integer picNo) {
		return dao.findByPK(picNo);
	}

	public List<PetImageVO> getAll() {
		return dao.getAll();
	}

	public List<PetImageVO> getPetPic(Integer petNo) {
		return dao.getPetPic(petNo);
	}
}
