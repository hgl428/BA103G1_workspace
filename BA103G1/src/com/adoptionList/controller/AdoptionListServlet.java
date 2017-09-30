package com.adoptionList.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adoptionList.model.AdoptionListVO;
import com.adoptionList.model.AdoptionService;
import com.petInformation.model.PetInformationService;
import com.petInformation.model.PetInformationVO;

@WebServlet("/AdoptionListServlet")
public class AdoptionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");  //知道要進入哪程式區塊
		
		
		if("delete".equals(action)){
			
			
			//第一步接值，從前端把值接進來
			Integer memNo = Integer.parseInt(req.getParameter("memNo"));
			Integer petNo = Integer.parseInt(req.getParameter("petNo"));
//			System.out.println("memNo"+memNo);
//			System.out.println("petNo="+petNo);
			
			//第二步叫service去資料庫把資料刪除，就取消那筆認養
			AdoptionService adoptSvc = new AdoptionService();
			adoptSvc.delete(memNo, petNo);  //放入二個fk(pk)
			
			//第三步，刪除成功，並轉回原頁
			req.setAttribute("AdoptionList", adoptSvc);
			String url = "/JSP/IpetB/applyList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交addAdopt.jsp
			successView.forward(req, res);
		}
		
		
		if("insert".equals(action)){
			//第一步接值，從前端把值接進來
			Integer petNo = Integer.parseInt(req.getParameter("petNo"));
			Integer memNo = Integer.parseInt(req.getParameter("memNo"));
			System.out.println("memNo"+memNo);
			System.out.println("petNo="+petNo);
			//第二步叫service去把資料新增到資料庫，就新增一個對某人對動物的提出認養
			PetInformationService InfoSvc = new PetInformationService();
			PetInformationVO petInfoVO = InfoSvc.getOnePetInfo(petNo); 
			//為了存入第三個欄位送養人是誰，把petinfo的service叫出來，然後找出memNo，再把值放入
			AdoptionService adoptSvc = new AdoptionService();
			adoptSvc.apply(memNo, petNo, petInfoVO.getMemNo());
			
			
			//第三步，刪除成功，並轉回原頁
			req.setAttribute("AdoptionList", adoptSvc);
			String url = "/JSP/IpetB/applyList.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交addAdopt.jsp
			successView.forward(req, res);
			
		}
		
	}

}