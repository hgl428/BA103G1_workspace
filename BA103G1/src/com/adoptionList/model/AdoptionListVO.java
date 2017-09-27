package com.adoptionList.model;

public class AdoptionListVO implements java.io.Serializable {

	private Integer memNo;
	private Integer petNo;
	private Integer supplyMen;

	public AdoptionListVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMemNo() {
		return memNo;
	}

	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}

	public Integer getPetNo() {
		return petNo;
	}

	public void setPetNo(Integer petNo) {
		this.petNo = petNo;
	}

	public Integer getSupplyMen() {
		return supplyMen;
	}

	public void setSupplyMen(Integer supplyMen) {
		this.supplyMen = supplyMen;
	}

}
