package com.petInformation.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PetBreed.model.PetBreedService;
import com.PetBreed.model.PetBreedVO;
import com.PetImage.model.PetImageService;
import com.PetImage.model.PetImageVO;
import com.PetSpecies.model.PetSpeciesService;
import com.PetSpecies.model.PetSpeciesVO;
import com.petInformation.model.*;

public class PetInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action"); // 知道送出鍵要進入哪個程式區塊

		if ("insert".equals(action)) { // 如果是進入新增程式區塊
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();

			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			// try {
			/***************************
			 * 把要新增的內容都列出來
			 **********************/

			String petName = req.getParameter("petName").trim();
			// if (petName == null || (petName.trim()).length() == 0) {
			// errorMsgs.add("請輸入動物名稱");
			// }
			// Send the use back to the form, if there were errors
			// if (!errorMsgs.isEmpty()) {
			// RequestDispatcher failureView =
			// req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
			// failureView.forward(req, res);
			// return;// 程式中斷
			// }
			Integer memNo = 123456;

			String petSex = req.getParameter("petSex");

			Integer speciesNo = null;
			if (req.getParameter("speciesNo").trim().length() == 0) {
				errorMsgs.put("speciesNo", "請選擇一個種類");
			} else {
				speciesNo = Integer.parseInt(req.getParameter("speciesNo"));
			}
			String petColor = req.getParameter("petColor").trim();

			Integer breedNo = null;
			if (req.getParameter("petBreed").trim().length() == 0) {
				errorMsgs.put("petBreed", "請選擇一個品種");
			} else {
				breedNo = Integer.parseInt(req.getParameter("petBreed"));
			}

			String petAge = req.getParameter("petAge").trim();

			String petSize = req.getParameter("petSize").trim();

			String position = null;

			if (req.getParameter("position").trim().length() == 0) {
				errorMsgs.put("postion", "請選擇縣市");
			} else {
				position = req.getParameter("position");
			}

			String addr = null;
			if (req.getParameter("addr").trim().length() == 0) {
				errorMsgs.put("addr", "請填寫地址");
			} else {
				position = req.getParameter("addr");
			}

			String petPosition = position + addr;

			String petIc = req.getParameter("petIc").trim();

			String TNR = req.getParameter("TNR").trim();

			String petTitle = req.getParameter("petTitle").trim();

			String situation = req.getParameter("situation").trim();

			Double Longitude = Double.parseDouble(req.getParameter("long"));

			Double Latitude = Double.parseDouble(req.getParameter("lat"));

			byte[] petFilm = null;

			PetInformationVO petInfoVO = new PetInformationVO();
			petInfoVO.setPetName(petName);
			petInfoVO.setPetSex(petSex);
			petInfoVO.setPetColor(petColor);
			petInfoVO.setPetAge(petAge);
			petInfoVO.setPetSize(petSize);
			petInfoVO.setPetPosition(petPosition);
			petInfoVO.setPetIc(petIc);
			petInfoVO.setTNR(TNR);
			petInfoVO.setPetTitle(petTitle);
			petInfoVO.setSituation(situation);
			petInfoVO.setPetLongitude(Longitude);
			petInfoVO.setPetLatitude(Latitude);
			petInfoVO.setPetFilm(petFilm);

			printlog(errorMsgs, petInfoVO);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("PetInformationVO", petInfoVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
				failureView.forward(req, res);
				return;
			}

			PetBreedVO breedVO = new PetBreedVO();
			breedVO.setBreedNo(breedNo);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("PetBreedVO", breedVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
				failureView.forward(req, res);
				return;

			}

			PetSpeciesVO speciesVO = new PetSpeciesVO();
			speciesVO.setSpeciesNo(speciesNo);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("PetSpeciesVO", speciesVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
				failureView.forward(req, res);
				return;
			}
			/*************************** 2.開始查詢資料 *****************************************/

			PetInformationService petInfoSvc = new PetInformationService();
			PetInformationVO petInfo = petInfoSvc.addPetInfo(memNo, breedNo, petName, petAge, petSize, petColor,
					petPosition, petIc, TNR, situation, petFilm, petTitle, Longitude, Latitude, petSex);

			PetSpeciesService petSpeciesSvc = new PetSpeciesService();
			PetSpeciesVO species = petSpeciesSvc.addPetSpecies(speciesNo);

			/***************************
			 * 3.新增完成,準備轉交(Send the Success view)
			 ***********/
			req.setAttribute("PetInformationVO", petInfo);
			req.setAttribute("PetSpeciesVO", species);
			String url = "/JSP/IpetB/adoption.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交addAdopt.jsp
			successView.forward(req, res);
			// }
			// catch (Exception e) {
			// errorMsgs.put("Exception", e.getMessage());
			// RequestDispatcher failureView =
			// req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
			// failureView.forward(req, res);
			// }
		}

	}
	// 錯誤驗證區

	public Map<String, String> printlog(Map<String, String> errorMsgs, PetInformationVO petInfoVO) {

		if (petInfoVO.getPetName() == null || petInfoVO.getPetName().trim().length() == 0) {
			errorMsgs.put("petName", "動物名稱請勿空白");
		} else if (petInfoVO.getPetColor() == null || petInfoVO.getPetColor().trim().length() == 0) {
			errorMsgs.put("petColor", "毛色請勿空白");
		} else if (petInfoVO.getPetAge() == null || petInfoVO.getPetAge().trim().length() == 0) {
			errorMsgs.put("petColor", "年紀請勿空白");
		} else if (petInfoVO.getPetPosition() == null || petInfoVO.getPetPosition().trim().length() == 0) {
			errorMsgs.put("petPostion", "送養地點請勿空白");
		} else if (petInfoVO.getPetTitle() == null || petInfoVO.getPetTitle().trim().length() == 0) {
			errorMsgs.put("petTitle", "送養標題請勿空白");
		} else if (petInfoVO.getSituation() == null || petInfoVO.getSituation().trim().length() == 0) {
			errorMsgs.put("situation", "動物現況請勿空白");
		} else if (petInfoVO.getPetSize() == null || petInfoVO.getPetSize().trim().length() == 0) {
			errorMsgs.put("petSize", "體型請勿空白");
		} else if (petInfoVO.getPetSex() == null || petInfoVO.getPetSex().trim().length() == 0) {
			errorMsgs.put("petSex", "性別請勿空白");
		}

		return errorMsgs;
	}

}
