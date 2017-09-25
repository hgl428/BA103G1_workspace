package com.petInformation.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PetBreed.model.PetBreedVO;
import com.PetImage.model.PetImageService;
import com.PetImage.model.PetImageVO;

import com.PetSpecies.model.PetSpeciesVO;
import com.petInformation.model.*;

@MultipartConfig(fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 5 * 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024
		* 1024) // 要東西要上傳必填
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
			//
			try {
				/***************************
				 * 把要新增的內容都列出來
				 **********************/

				String petName = req.getParameter("petName");
				if (req.getParameter("petName").trim().length() == 0) {
					errorMsgs.put("petName", "請填寫動物名稱");
				} else {
					petName = req.getParameter("petName");
				}

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
				String petColor = req.getParameter("petColor");
				if (req.getParameter("petColor").trim().length() == 0) {
					errorMsgs.put("petColor", "請選擇一個毛色");
				} else {
					petColor = req.getParameter("petColor");
				}
				Integer breedNo = null;
				if (req.getParameter("petBreed").trim().length() == 0) {
					errorMsgs.put("petBreed", "請選擇一個品種");
				} else {
					breedNo = Integer.parseInt(req.getParameter("petBreed"));
				}

				String petAge = req.getParameter("petAge").trim();

				String petSize = null;
				if (req.getParameter("petSize").trim().length() == 0) {
					errorMsgs.put("petSize", "請選擇一個體型");
				} else {
					petSize = req.getParameter("petSize");
				}
				//
				String position = null;

				if (req.getParameter("position").trim().length() == 0) {
					errorMsgs.put("position", "請選擇縣市");
				} else {
					position = req.getParameter("position");
				}

				String addr = null;
				if (req.getParameter("addr").trim().length() == 0) {
					errorMsgs.put("addr", "請填寫地址");
				} else {
					addr = req.getParameter("addr");
				}

				String petPosition = position + addr;

				String petIc = req.getParameter("petIc").trim();

				String TNR = req.getParameter("TNR").trim();

				String petTitle = null;
				if (req.getParameter("petTitle").trim().length() == 0) {
					errorMsgs.put("petTitle", "請輸入送養標題");
				} else {
					petTitle = req.getParameter("petTitle");
				}

				String situation = null;
				if ( req.getParameter("situation").trim().length() == 0) {
					errorMsgs.put("situation", "請輸入送養內容");
				} else {
					situation = req.getParameter("situation");
				}
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

				InputStream petImage = req.getPart("petImage1").getInputStream(); // 把上傳的照片name=petImage1抓進來

				byte[] petImage1 = null; // 宣告放petImage1的地方

				// if
				// (req.getPart("petImage1").getContentType().contains("image/gif")){
				// // 判斷有無照片上傳

				// petImage1 = (byte[]) req.getAttribute("petImage1"); //
				// 抓使用者之前上傳的圖
				// if (petImage1 == null) {
				// errorMsgs.put("petImage1", "請上傳動物圖片"); // 如果沒選就給提示訊息
				// } else {
				ByteArrayOutputStream buffer = new ByteArrayOutputStream(); // 緩衝區

				int len; // 水桶
				byte[] buf = new byte[4 * 1024]; // 4K buffer 水瓢
				while ((len = petImage.read(buf)) != -1) { // 一個水桶裝滿就倒 把照片讀進來
					buffer.write(buf, 0, len); // 最後從第一桶開始倒，倒到剩下，要小心最後一桶是倒全部還是倒剩下的。
				}
				petImage1 = buffer.toByteArray(); // 把圖一轉成byte陣列
				System.out.print(petImage1.length);
				req.setAttribute("petImageVO", petImage);
				// }

				String picName1 = null;
				if (req.getParameter("picName1").trim().length() == 0) {
					errorMsgs.put("picName1", "請輸入照片名稱");
				} else {
					picName1 = req.getParameter("picName1");
				}

				// System.out.println(picName1);

				PetImageVO imageVO = new PetImageVO();

				imageVO.setpetPicture(petImage1); // 放傳進來的照片petImage1
				imageVO.setPicName(picName1);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("PetImageVO", imageVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始查詢資料 *****************************************/

				PetInformationService petInfoSvc = new PetInformationService();
				PetInformationVO petInfo = petInfoSvc.addPetInfo(memNo, breedNo, petName, petAge, petSize, petColor,
						petPosition, petIc, TNR, situation, petFilm, petTitle, Longitude, Latitude, petSex);
				// System.out.println("3"+petImage1);
				// PetSpeciesService petSpeciesSvc = new PetSpeciesService();
				// PetSpeciesVO species =
				// petSpeciesSvc.addPetSpecies(speciesNo);
				// System.out.println("4"+petImage1);
				// System.out.println(petInfo.getPetNo());
				PetImageService petImgSvc = new PetImageService();
				PetImageVO petPic = petImgSvc.addPetImage(petInfo.getPetNo(), petImage1, picName1);
				// 因為petInfo已經會回傳一個petNo了，所以可以直接用
				// System.out.println("5"+petImage1);

				/***************************
				 * 3.新增完成,準備轉交(Send the Success view)
				 ***********/
				req.setAttribute("PetInformationVO", petInfo);

				req.setAttribute("PetImageVO", petPic);
				String url = "/JSP/IpetB/adoption.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交addAdopt.jsp
				successView.forward(req, res);
			}

			catch (Exception e) {

				errorMsgs.put("Exception", e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/JSP/IpetB/addAdopt.jsp");
				failureView.forward(req, res);
			}
		}

	}
	// 錯誤驗證區

	public Map<String, String> printlog(Map<String, String> errorMsgs, PetInformationVO petInfoVO) {

		if (petInfoVO.getPetName() == null || petInfoVO.getPetName().trim().length() == 0) {
			errorMsgs.put("petName", "動物名稱請勿空白");
		} else if (petInfoVO.getPetColor() == null || petInfoVO.getPetColor().trim().length() == 0) {
			errorMsgs.put("petColor", "毛色請勿空白");
		} else if (petInfoVO.getPetAge() == null || petInfoVO.getPetAge().trim().length() == 0) {
			errorMsgs.put("petAge", "年紀請勿空白");
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
