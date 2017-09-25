package com.PetView.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_petView;

public class PetViewDao implements PetViewDao_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle驅動
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";
	private static final String GET_ONE_INFO = "select speciesName,breedName,petNo,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petDate,petFilm,petTitle,petSex from PETALLINFORMATION where petNo=?";
	private static final String GET_ALL = "select speciesName,breedName,petNo,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petDate,petFilm,petTitle,petSex from PETALLINFORMATION";

	public static void main(String[] args) {
		PetViewDao dao = new PetViewDao();
		// TODO Auto-generated method stub
		// List<PetViewVO> PVO3 = dao.getAll();

		// for (PetViewVO list : PVO3) {
		//
		// System.out.println(list.getSpeciesName() + ",");
		// System.out.println(list.getBreedName() + ",");
		// System.out.println(list.getPetNo() + ",");
		// System.out.println(list.getPetName() + ",");
		// System.out.println(list.getPetAge() + ",");
		// System.out.println(list.getPetSize() + ",");
		// System.out.println(list.getPetColor() + ",");
		// System.out.println(list.getPetPosition() + ",");
		// System.out.println(list.getPetIc() + ",");
		// System.out.println(list.getTNR() + ",");
		// System.out.println(list.getSituation() + ",");
		// System.out.println(list.getPetDate() + ",");
		// System.out.println(list.getPetFilm() + ",");
		// System.out.println(list.getPetTitle() + ",");
		// System.out.println(list.getPetSex() + ",");
		// }

//		List<PetViewVO> PVO3 = dao.getSome();
//		for (PetViewVO list : PVO3) {
//
//			System.out.println(list.getSpeciesName() + ",");
//			System.out.println(list.getBreedName() + ",");
//			System.out.println(list.getPetName() + ",");
//			System.out.println(list.getPetPosition() + ",");
//			System.out.println(list.getSituation() + ",");
//			System.out.println(list.getPetTitle() + ",");
//			System.out.println(list.getPetSex() + ",");
//		}
	}

//	@Override
//	public List<PetViewVO> getSome() {
//		// TODO Auto-generated method stub
//
//		List<PetViewVO> some = new ArrayList<PetViewVO>();
//
//		PetViewVO petViewVO = null;
//
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			Class.forName(DRIVER);
//			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			ps = con.prepareStatement(GET_SOME_INFO);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				petViewVO = new PetViewVO();
//				petViewVO.setSpeciesName(rs.getString("speciesName"));
//				petViewVO.setBreedName(rs.getString("breedName"));
//				petViewVO.setPetTitle(rs.getString("petTitle"));
//				petViewVO.setPetPosition(rs.getString("petPosition"));
//				petViewVO.setSituation(rs.getString("Situation"));
//				petViewVO.setPetAge(rs.getString("petSex"));
//				petViewVO.setPetName(rs.getString("petName"));
//
//				some.add(petViewVO);
//
//			}
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if (ps != null) {
//					try {
//						ps.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return some;
//
//	}

	@Override
	public List<PetViewVO> getAll() {
		// TODO Auto-generated method stub

		List<PetViewVO> list = new ArrayList<PetViewVO>();

		PetViewVO petViewVO = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();

			while (rs.next()) {

				petViewVO = new PetViewVO();
				petViewVO.setSpeciesName(rs.getString("speciesName"));
				petViewVO.setBreedName(rs.getString("breedName"));
				petViewVO.setPetNo(rs.getInt("petNo"));
				petViewVO.setPetName(rs.getString("petName"));
				petViewVO.setPetAge(rs.getString("petAge"));
				petViewVO.setPetSize(rs.getString("petSize"));
				petViewVO.setPetSize(rs.getString("petColor"));
				petViewVO.setPetPosition(rs.getString("petPosition"));
				petViewVO.setPetIc(rs.getString("petIc"));
				petViewVO.setTNR(rs.getString("TNR"));
				petViewVO.setSituation(rs.getString("Situation"));
				petViewVO.setPetDate(rs.getDate("petDate"));
				petViewVO.setPetFilm(rs.getBytes("petFilm"));
				petViewVO.setPetTitle(rs.getString("petTitle"));
				petViewVO.setPetSex(rs.getString("petSex"));

				list.add(petViewVO);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<PetViewVO> getAll(Map<String, String[]> map) {
		List<PetViewVO> list = new ArrayList<PetViewVO>();
		PetViewVO petViewVO = null;
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			
			con = ds.getConnection();
			String finalSQL = "select * from PETALLINFORMATION "
		          + jdbcUtil_CompositeQuery_petView.get_WhereCondition(map)
		          + "order by petDate";
			ps = con.prepareStatement(finalSQL);
			System.out.println("finalSQL(by DAO) = "+finalSQL);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				petViewVO = new PetViewVO();
				petViewVO.setSpeciesName(rs.getString("speciesName"));
				petViewVO.setBreedName(rs.getString("breedName"));
				petViewVO.setPetNo(rs.getInt("petNo"));
				petViewVO.setPetName(rs.getString("petName"));
				petViewVO.setPetAge(rs.getString("petAge"));
				petViewVO.setPetSize(rs.getString("petSize"));
				petViewVO.setPetSize(rs.getString("petColor"));
				petViewVO.setPetPosition(rs.getString("petPosition"));
				petViewVO.setPetIc(rs.getString("petIc"));
				petViewVO.setTNR(rs.getString("TNR"));
				petViewVO.setSituation(rs.getString("Situation"));
				petViewVO.setPetDate(rs.getDate("petDate"));
				petViewVO.setPetFilm(rs.getBytes("petFilm"));
				petViewVO.setPetTitle(rs.getString("petTitle"));
				petViewVO.setPetSex(rs.getString("petSex")); // Store the row in the List
				
				list.add(petViewVO);
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public PetViewVO findByPetNo(Integer petNo) {
		// TODO Auto-generated method stub
		 PetViewVO petViewVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_ONE_INFO);
			ps.setInt(1, petNo); // 就是第一個問號，pk的編號

			// 然後把執行的結果放入ResultSet內
			rs = ps.executeQuery();
			// 把rs裡面的東西一個一個撈出來，再秀出
			while (rs.next()) {
				// 實體初始化
				
				petViewVO = new PetViewVO();
				petViewVO.setSpeciesName(rs.getString("speciesName"));
				petViewVO.setBreedName(rs.getString("breedName"));
				petViewVO.setPetNo(rs.getInt("petNo"));
				petViewVO.setPetName(rs.getString("petName"));
				petViewVO.setPetAge(rs.getString("petAge"));
				petViewVO.setPetSize(rs.getString("petSize"));
				petViewVO.setPetColor(rs.getString("petColor"));
				petViewVO.setPetPosition(rs.getString("petPosition"));
				petViewVO.setPetIc(rs.getString("petIc"));
				petViewVO.setTNR(rs.getString("TNR"));
				petViewVO.setSituation(rs.getString("Situation"));
				petViewVO.setPetDate(rs.getDate("petDate"));
				petViewVO.setPetFilm(rs.getBytes("petFilm"));
				petViewVO.setPetTitle(rs.getString("petTitle"));
				petViewVO.setPetSex(rs.getString("petSex"));


			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (ps != null) {
				try {
					ps.cancel();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return petViewVO; // 別忘了回傳VO實體物件(KEY物件名稱)
	}

	

}
