package com.PetView.model;

import java.sql.Date;

public class PetViewVO implements java.io.Serializable{
	private Integer speciesNo; // 種類編號
	private String speciesName; // 種類名稱
	private Integer breedNo; // 品種編號
	private String breedName; // 品種名稱
	private Integer petNo; // 動物編號
	private Integer memNo; // 送養人編號
	private String status; // 送養狀態
	private String petName; // 動物暱稱
	private String petAge; // 動物年紀
	private String petSize; // 動物體型
	private String petColor; // 動物顏色
	private String petPosition; // 送養地點
	private String petIc; // 有無IC
	private String TNR; // 有無節育
	private String situation; // 動物狀況
	private Date petDate; // 發文日
	private byte[] petFilm; // 動物影片
	private String petTitle; // 送養標題
	private String petSex; // 動物性別
	private Double petLongitude;
	private Double petLatitude;




	public PetViewVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSpeciesNo() {
		return speciesNo;
	}

	public void setSpeciesNo(Integer speciesNo) {
		this.speciesNo = speciesNo;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public Integer getBreedNo() {
		return breedNo;
	}

	public void setBreedNo(Integer breedNo) {
		this.breedNo = breedNo;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public Integer getPetNo() {
		return petNo;
	}

	public void setPetNo(Integer petNo) {
		this.petNo = petNo;
	}

	public Integer getMemNo() {
		return memNo;
	}

	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetAge() {
		return petAge;
	}

	public void setPetAge(String petAge) {
		this.petAge = petAge;
	}

	public String getPetSize() {
		return petSize;
	}

	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}

	public String getPetColor() {
		return petColor;
	}

	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}

	public String getPetPosition() {
		return petPosition;
	}

	public void setPetPosition(String petPosition) {
		this.petPosition = petPosition;
	}

	public String getPetIc() {
		return petIc;
	}

	public void setPetIc(String petIc) {
		this.petIc = petIc;
	}

	public String getTNR() {
		return TNR;
	}

	public void setTNR(String tNR) {
		TNR = tNR;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Date getPetDate() {
		return petDate;
	}

	public void setPetDate(Date petDate) {
		this.petDate = petDate;
	}

	public byte[] getPetFilm() {
		return petFilm;
	}

	public void setPetFilm(byte[] petFilm) {
		this.petFilm = petFilm;
	}

	public String getPetTitle() {
		return petTitle;
	}

	public void setPetTitle(String petTitle) {
		this.petTitle = petTitle;
	}

	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}

	public Double getPetLongitude() {
		return petLongitude;
	}

	public void setPetLongitude(Double petLongitude) {
		this.petLongitude = petLongitude;
	}

	public Double getPetLatitude() {
		return petLatitude;
	}

	public void setPetLatitude(Double petLatitude) {
		this.petLatitude = petLatitude;
	}
}
