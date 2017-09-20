package com.PetImage.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetImageServlet
 */
@WebServlet("/GetImageServlet")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif"); // 傳進來是圖片型態
		ServletOutputStream out = res.getOutputStream(); // 用二位元輸出到瀏覽器

		Connection con =null;
		try {
			Statement stmt = con.createStatement(); // 下SQL指令
			String picNo = req.getParameter("picNo");

			ResultSet rs = stmt.executeQuery( // 執行後丟到RS

					"SELECT petPicture FROM PetImage WHERE picNo = '" + picNo + "'");
			// "SELECT picture FROM emp_photo WHERE empno = 'C_2511'");
			// //抓圖的SQL指令

			if (rs.next()) { // RS裡的東西一個一個撈出來
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("petPicture"));
				// 用BufferedInputStream來處理，把rs裡想抓的照片以位元的方式放倒進去
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len; // 水桶
				while ((len = in.read(buf)) != -1) { // 一個水桶裝滿就倒
					out.write(buf, 0, len); // 最後從第一桶開始倒，倒到剩下，要小心最後一桶是倒全部還是倒剩下的。
				}
				in.close();
			} else {

				InputStream in = getServletContext().getResourceAsStream("/NoData/no.jpg");
				// 如果沒有圖，就會換到預設圖的畫面，指定圖的內容
				byte[] buf = new byte[in.available()]; // 讀byte萬用招
				in.read(buf);
				out.write(buf);
				in.close();
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			InputStream in = getServletContext().getResourceAsStream("/NoData/no.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
