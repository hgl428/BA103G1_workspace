package com.PetBreed.model;

public class PetBreedVO implements java.io.Serializable{
	
	private Integer breedNo;
	private String breedName;
	private Integer speciesNo;
	
	public PetBreedVO(){
		super();
	}
	
	public Integer getBreedNo(){
		return breedNo;
	}
	public void setBreedNo(Integer breedNo){
		this.breedNo = breedNo;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public Integer getSpeciesNo() {
		return speciesNo;
	}

	public void setSpeciesNo(Integer speciesNo) {
		this.speciesNo = speciesNo;
	}
	
}
