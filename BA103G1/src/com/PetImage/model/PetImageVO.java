package com.PetImage.model;


public class PetImageVO implements java.io.Serializable{
	
	private Integer picNo;
	private Integer petNo;
	private byte[] petPicture;
	private String picNote;
	private String picName;
	
	public PetImageVO(){
		super();
	}
	public void setPicNo(Integer picNo){
		this.picNo = picNo;
	}
	public Integer getPicNo(){
		return picNo;
	}
	
	public void setPetNo(Integer petNo){
		this.petNo = petNo;
	}
	public Integer getPetNo(){
		return petNo;
	}
	
	public void setpetPicture(byte[] petPicture){
		this.petPicture = petPicture;
	}
	public byte[] getpetPicture(){
		return petPicture;
	}
	
	public void setPicNote(String picNote){
		this.picNote = picNote;
	}
	public String getPicNote(){
		return picNote;
	}
	
	public void setPicName(String picName){
		this.picName = picName;
	}
	public String getPicName(){
		return picName;
	}
}