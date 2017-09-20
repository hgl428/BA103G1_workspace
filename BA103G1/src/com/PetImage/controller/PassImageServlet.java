package com.PetImage.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.PetImage.model.PetImageService;
import com.PetImage.model.PetImageVO;

public class PassImageServlet extends HttpServlet {

	Connection con=null;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");   //傳進來是圖片型態
		ServletOutputStream out = res.getOutputStream();   //用二位元輸出到瀏覽器

		try {
			Statement stmt = con.createStatement();   //下SQL指令
			ResultSet rs = stmt.executeQuery(         //執行後丟到RS
				"SELECT petPicture FROM petImage WHERE picNo = ");
//				"SELECT picture FROM emp_photo WHERE empno = 'C_2511'");  //抓圖的SQL指令

			if (rs.next()) {   //RS裡的東西一個一個撈出來
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("picture"));   
				//用BufferedInputStream來處理，把rs裡想抓的照片以位元的方式放倒進去
				byte[] buf = new byte[4 * 1024]; // 4K buffer 
				int len;   //水桶
				while ((len = in.read(buf)) != -1) {  //一個水桶裝滿就倒
					out.write(buf, 0, len);    //最後從第一桶開始倒，倒到剩下，要小心最後一桶是倒全部還是倒剩下的。
				}
				in.close();
			} else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

		PetImageService picSvc = new PetImageService();

		PetImageVO imageVO = picSvc.getOnePetImage(12);
		req.setAttribute("imageVO", imageVO);
		String url = "/JSP/IpetB/adopt-content.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);

	}

	public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext(); 
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB"); 
			con = ds.getConnection();
		} catch (Exception e) {
			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
		}
	}

	public void destroy() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
