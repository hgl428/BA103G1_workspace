package com.PetView.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetViewDaoJDBC implements PetViewDao_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle驅動
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";
	private static final String GET_SOME_INFO = "select speciesName,breedName,petTitle,petPosition,situation,petSex,petName from PETALLINFORMATION";
	private static final String GET_ALL = "select speciesName,breedName,petNo,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petDate,petFilm,petTitle,petSex from PETALLINFORMATION";

	public static void main(String[] args) {
		PetViewDaoJDBC dao = new PetViewDaoJDBC();
		// TODO Auto-generated method stub
		 List<PetViewVO> PVO3 = dao.getAll();

		 for (PetViewVO list : PVO3) {
		
		 System.out.println(list.getSpeciesName() + ",");
		 System.out.println(list.getBreedName() + ",");
		 System.out.println(list.getPetNo() + ",");
		 System.out.println(list.getPetName() + ",");
		 System.out.println(list.getPetAge() + ",");
		 System.out.println(list.getPetSize() + ",");
		 System.out.println(list.getPetColor() + ",");
		 System.out.println(list.getPetPosition() + ",");
		 System.out.println(list.getPetIc() + ",");
		 System.out.println(list.getTNR() + ",");
		 System.out.println(list.getSituation() + ",");
		 System.out.println(list.getPetDate() + ",");
		 System.out.println(list.getPetFilm() + ",");
		 System.out.println(list.getPetTitle() + ",");
		 System.out.println(list.getPetSex() + ",");
		 }

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

	@Override
	public List<PetViewVO> getSome() {
		// TODO Auto-generated method stub

		List<PetViewVO> some = new ArrayList<PetViewVO>();

		PetViewVO petViewVO = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_SOME_INFO);
			rs = ps.executeQuery();

			while (rs.next()) {
				petViewVO = new PetViewVO();
				petViewVO.setSpeciesName(rs.getString("speciesName"));
				petViewVO.setBreedName(rs.getString("breedName"));
				petViewVO.setPetTitle(rs.getString("petTitle"));
				petViewVO.setPetPosition(rs.getString("petPosition"));
				petViewVO.setSituation(rs.getString("Situation"));
				petViewVO.setPetAge(rs.getString("petSex"));
				petViewVO.setPetName(rs.getString("petName"));

				some.add(petViewVO);

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
		return some;

	}

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
				petViewVO.setPetAge(rs.getString("petSex"));

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

}
