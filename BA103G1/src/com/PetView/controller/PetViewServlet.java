package com.PetView.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PetView.model.PetViewService;
import com.PetView.model.PetViewVO;

@WebServlet("/PetViewServlet")
public class PetViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("petView".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/*************************** 1.�N��J����ରMap **********************************/
				// �ĥ�Map<String,String[]> getParameterMap()����k
				// �`�N:an immutable java.util.Map
				// Map<String, String[]> map = req.getParameterMap();
				Map<String, String[]> map =req.getParameterMap();
				/*************************** 2.�}�l�ƦX�d�� ***************************************/
				PetViewService viewSvc = new PetViewService();
				List<PetViewVO> list = viewSvc.getAll(map);
				if(list==null){
					
				}
				System.out.println("印list有幾個:"+list.size());
				/***************************
				 * 3.�d�ߧ���,�ǳ����(Send the Success view)
				 ************/
				
				req.setAttribute("petViewList", list); //
				RequestDispatcher successView = req.getRequestDispatcher("/JSP/IpetB/adoption.jsp"); // 
				successView.forward(req, res);

				/*************************** ��L�i�઺���~�B�z **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/JSP/IpetB/adoption.jsp");
				failureView.forward(req, res);
			}

		}

	}
}