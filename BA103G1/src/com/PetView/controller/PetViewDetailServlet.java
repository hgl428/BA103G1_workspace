package com.PetView.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PetView.model.PetViewService;
import com.PetView.model.PetViewVO;

@WebServlet("/PetViewDatailServlet")
public class PetViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PetViewDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		Integer petNo = Integer.parseInt(req.getParameter("petNo"));   
//		String petNo = req.getParameter("petNo");
		// 用getParameter的方法得到?後面的名稱去取得   就等於form表單得到name一樣  去抓到值(動物的編號) 抓adoption.jsp那頁的內容，去抓到看是哪一隻動物
		System.out.println("動物編號"+petNo);
		
		PetViewService petViewSvc = new PetViewService();   //創造一個方法是用動物編號去找到要秀出的內容，然後再做一個service的方法 ，創造老大出來
		PetViewVO petviewVO = petViewSvc.getOnePet(petNo);  //就可以用老大的方法去把某動物督號的所有資料打包成vo
		
		req.setAttribute("petviewVO",petviewVO);   
//		System.out.println("種類名稱:"+petviewVO.getSpeciesName());
		//拿到這個vo沒問題就把資料set成requestscope的資料，把petviewVO這個值取個變數名稱"AdoptContent"，
		//然後傳給要forward的網頁，就可以直接用，可以取值了。
		String url = "/JSP/IpetB/adopt-content.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交addAdopt.jsp
		successView.forward(req, res);
		
	}

}
