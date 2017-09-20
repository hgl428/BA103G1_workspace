package com.PetSpecies.model;

public class PetSpeciesVO implements java.io.Serializable{
	
	private Integer speciesNo;
	private String speciesName;
	
	public PetSpeciesVO(){
		super();
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
	
	
}