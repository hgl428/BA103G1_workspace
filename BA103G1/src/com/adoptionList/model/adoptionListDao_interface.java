package com.adoptionList.model;

import java.util.List;

public interface AdoptionListDao_interface {

	public void insert(AdoptionListVO adoptionListVO); // 提出送養申請

	public void delete(Integer memNo, Integer petNo); // 取消申請(取消自己)//拒絕領養人`

	public List<AdoptionListVO> getApplyPet(Integer memNo); // 領養人對幾隻動物提出申請，回傳全部的動物

	public void deleteAllApplyPet(Integer petNo); // 送養人確認誰領養後，刪除跟動物有關的所有領養人

}
