package com.petInformation.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class PetInformationDaoJDBC implements PetInformationDao_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle驅動
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";

	private static final String INSERT_SQL ="INSERT INTO petInformation (petNo,memNo,breedNo,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petFilm,petTitle,petLongitude,petLatitude,petSex)VALUES (petInformation_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_SQL = "Update petInformation set breedNo=?, status=?, petName=?, petAge=?, petSize=?, petColor=?, petPosition=?,"
			+ "petIc=?, TNR=?, situation=?, petFilm=?, petTitle=?, petSex=? where petNo=?";
	private static final String DELETE_SQL = "delete from PetInformation where petNo = ?";
	private static final String GET_ONE_SQL = "select memNo,breedNo,status,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petDate,petFilm,petTitle,pexSex from Petinformation where petNo=?";
	private static final String GETALL_SQL = "select * from petInformation";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PetInformationDaoJDBC dao = new PetInformationDaoJDBC();

		// 新增
		PetInformationVO PVO1 = new PetInformationVO();
		
		 PVO1.setMemNo(222);
		 PVO1.setBreedNo(10);
		
		 PVO1.setPetName("好帥");
		 PVO1.setPetAge("幼");
		 PVO1.setPetSize("中");
		 PVO1.setPetColor("黑");
		 PVO1.setPetPosition("桃園市中壢區中央路300號");
		 PVO1.setPetIc("有");
		 PVO1.setTNR("無");
		 PVO1.setSituation("快樂的不得了");
		
		
		 PVO1.setPetFilm(null);
		 PVO1.setPetTitle("史上無敵可愛");
		 PVO1.setPetLongitude(123.0111100);
		 PVO1.setPetLatitude(111.0000000);
		 PVO1.setPetSex("公");
		
		 dao.insert(PVO1);


		// 修改

		//
		// PetInformationVO PVO2 = new PetInformationVO();
		//
		// PVO2.setBreedNo(11);
		// PVO2.setStatus("審核中");
		// PVO2.setPetName("哈吉");
		// PVO2.setPetAge("幼");
		// PVO2.setPetSize("小");
		// PVO2.setPetColor("白");
		// PVO2.setPetPosition("台中市太平區中山路111號");
		// PVO2.setPetIc("無");
		// PVO2.setTNR("有");
		// PVO2.setSituation("現在是個超級健康寶寶，而且超可愛");
		// PVO2.setPetFilm(null);
		// PVO2.setPetTitle("超級黏人的狗狗");
		// PVO2.setPetNo(10);
		//
		// dao.update(PVO2);

		//
		// // 刪除
		//
		// dao.delete(11);
		//
		// 查詢某一動物
		// PetInformationVO PVO3 = dao.findByPK(2);
		//
		// System.out.println(PVO3.getMemNo() + ",");
		// System.out.println(PVO3.getBreedNo() + ",");
		// System.out.println(PVO3.getStatus() + ",");
		// System.out.println(PVO3.getPetName() + ",");
		// System.out.println(PVO3.getPetAge() + ",");
		// System.out.println(PVO3.getPetSize() + ",");
		// System.out.println(PVO3.getPetColor() + ",");
		// System.out.println(PVO3.getPetPosition() + ",");
		// System.out.println(PVO3.getPetIc() + ",");
		// System.out.println(PVO3.getTNR() + ",");
		// System.out.println(PVO3.getSituation() + ",");
		// System.out.println(PVO3.getPetDate() + ",");
		// System.out.println(PVO3.getPetFilm() + ",");
		// System.out.println(PVO3.getPetTitle() + ",");

		// // 查詢全部
		//
		// List<PetInformationVO> list = dao.getAll();
		// for (PetInformationVO get : list) {
		// System.out.println(get.getPetNo() + ",");
		// System.out.println(get.getMemNo() + ",");
		// System.out.println(get.getBreedNo() + ",");
		// System.out.println(get.getStatus() + ",");
		// System.out.println(get.getPetName() + ",");
		// System.out.println(get.getPetAge() + ",");
		// System.out.println(get.getPetSize() + ",");
		// System.out.println(get.getPetColor() + ",");
		// System.out.println(get.getPetPosition() + ",");
		// System.out.println(get.getPetIc() + ",");
		// System.out.println(get.getTNR() + ",");
		// System.out.println(get.getSituation() + ",");
		// System.out.println(get.getPetDate() + ",");
		// System.out.println(get.getMemNo2() + ",");
		// System.out.println(get.getPetFilm() + ",");
		// System.out.println(get.getPetTitle() + ",");
		// System.out.println(get.getPetSex() + ",");
		// System.out.println();
		//
		// }

	}

	@Override
	public void insert(PetInformationVO informationVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(INSERT_SQL);

			ps.setInt(1, informationVO.getMemNo());
			ps.setInt(2, informationVO.getBreedNo());
		
			ps.setString(3, informationVO.getPetName());
			ps.setString(4, informationVO.getPetAge());
			ps.setString(5, informationVO.getPetSize());
			ps.setString(6, informationVO.getPetColor());
			ps.setString(7, informationVO.getPetPosition());
			ps.setString(8, informationVO.getPetIc());
			ps.setString(9, informationVO.getTNR());
			ps.setString(10, informationVO.getSituation());
		
		
			ps.setBytes(11, informationVO.getPetFilm());
			ps.setString(12, informationVO.getPetTitle());
			ps.setDouble(13, informationVO.getPetLongitude());
			ps.setDouble(14, informationVO.getPetLatitude());
			ps.setString(15, informationVO.getPetSex());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	@Override
	public void update(PetInformationVO informationVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(UPDATE_SQL);

			ps.setInt(1, informationVO.getBreedNo());
			ps.setString(2, informationVO.getStatus());
			ps.setString(3, informationVO.getPetName());
			ps.setString(4, informationVO.getPetAge());
			ps.setString(5, informationVO.getPetSize());
			ps.setString(6, informationVO.getPetColor());
			ps.setString(7, informationVO.getPetPosition());
			ps.setString(8, informationVO.getPetIc());
			ps.setString(9, informationVO.getTNR());
			ps.setString(10, informationVO.getSituation());
			ps.setBytes(11, informationVO.getPetFilm());
			ps.setString(12, informationVO.getPetTitle());
			ps.setString(13, informationVO.getPetSex());
			ps.setInt(14, informationVO.getPetNo());
		
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void delete(Integer petNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(DELETE_SQL);

			ps.setInt(1, petNo);

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
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

	}

	@Override
	public PetInformationVO findByPK(Integer petNo) {
		// TODO Auto-generated method stub

		PetInformationVO informationVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_ONE_SQL);
			ps.setInt(1, petNo); // 就是第一個問號，pk的編號

			// 然後把執行的結果放入ResultSet內
			rs = ps.executeQuery();
			// 把rs裡面的東西一個一個撈出來，再秀出
			while (rs.next()) {
				// 實體初始化
				informationVO = new PetInformationVO();

				informationVO.setMemNo(rs.getInt("memNo"));
				informationVO.setBreedNo(rs.getInt("breedNo"));
				informationVO.setStatus(rs.getString("status"));
				informationVO.setPetName(rs.getString("petName"));
				informationVO.setPetAge(rs.getString("petAge"));
				informationVO.setPetSize(rs.getString("petSize"));
				informationVO.setPetColor(rs.getString("petColor"));
				informationVO.setPetPosition(rs.getString("petPosition"));
				informationVO.setPetIc(rs.getString("petIc"));
				informationVO.setTNR(rs.getString("TNR"));
				informationVO.setSituation(rs.getString("situation"));
				informationVO.setPetDate(rs.getDate("petDate"));
				informationVO.setPetFilm(rs.getBytes("petFilm"));
				informationVO.setPetTitle(rs.getString("petTitle"));
				informationVO.setPetSex(rs.getString("petSex"));

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

		return informationVO; // 別忘了回傳VO實體物件(KEY物件名稱)
	}

	@Override
	public List<PetInformationVO> getAll() {
		// TODO Auto-generated method stub
		List<PetInformationVO> list = new ArrayList<PetInformationVO>();

		PetInformationVO informationVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				informationVO = new PetInformationVO();

				informationVO.setPetNo(rs.getInt("petNo"));
				informationVO.setMemNo(rs.getInt("memNo"));
				informationVO.setBreedNo(rs.getInt("breedNo"));
				informationVO.setStatus(rs.getString("status"));
				informationVO.setPetName(rs.getString("petName"));
				informationVO.setPetAge(rs.getString("petAge"));
				informationVO.setPetSize(rs.getString("petSize"));
				informationVO.setPetColor(rs.getString("petColor"));
				informationVO.setPetPosition(rs.getString("petPosition"));
				informationVO.setPetIc(rs.getString("petIc"));
				informationVO.setTNR(rs.getString("TNR"));
				informationVO.setSituation(rs.getString("situation"));
				informationVO.setPetDate(rs.getDate("petDate"));
				informationVO.setPetFilm(rs.getBytes("petFilm"));
				informationVO.setPetTitle(rs.getString("petTitle"));
				informationVO.setPetSex(rs.getString("petSex"));

				list.add(informationVO);
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
