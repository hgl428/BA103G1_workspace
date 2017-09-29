package com.petInformation.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.PetImage.model.PetImageVO;

public class PetInformationDaoJDBC implements PetInformationDao_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle驅動
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";

	private static final String INSERT_SQL = "INSERT INTO petInformation (petNo,memNo,breedNo,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petFilm,petTitle,petLongitude,petLatitude,petSex)VALUES (petInformation_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_SQL = "Update petInformation set breedNo = ?, petName = ?, petAge = ?, petSize = ?, petColor = ?, petPosition = ?, petIc = ?, TNR = ?,"
			+ " situation = ?, petDate = ?, petFilm = ?, petTitle = ?, petLongitude = ?, petLatitude = ?, petSex = ? where petNo = ?";
	private static final String DELETE_SQL = "delete from PetInformation where petNo = ?";
	private static final String GET_ONE_SQL = "select memNo,breedNo,status,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petDate,petFilm,petTitle,pexSex from Petinformation where petNo=?";
	private static final String GETALL_SQL = "select * from petInformation";
	private static final String GET_SUPPLY_PET = "select * from petInformation where memNo =?";
//	private static final String COMFIRM_SQL = "select "

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PetInformationDaoJDBC dao = new PetInformationDaoJDBC();

		List<PetInformationVO> list = dao.getSupplyPet(111111);
		// 要顯示出來的內容，一定要set，不然秀不出來
		for (PetInformationVO pet : list) {
			System.out.println(pet.getPetNo());
			System.out.println(pet.getPetName());
			System.out.println(pet.getStatus());
			System.out.println(pet.getPetDate());
			System.out.println(pet.getPetTitle());
		}

		// 新增
		// PetInformationVO PVO1 = new PetInformationVO();
		//
		// PVO1.setMemNo(222);
		// PVO1.setBreedNo(10);
		//
		// PVO1.setPetName("好帥");
		// PVO1.setPetAge("幼");
		// PVO1.setPetSize("中");
		// PVO1.setPetColor("黑");
		// PVO1.setPetPosition("桃園市中壢區中央路300號");
		// PVO1.setPetIc("有");
		// PVO1.setTNR("無");
		// PVO1.setSituation("快樂的不得了");
		//
		//
		// PVO1.setPetFilm(null);
		// PVO1.setPetTitle("史上無敵可愛");
		// PVO1.setPetLongitude(123.0111100);
		// PVO1.setPetLatitude(111.0000000);
		// PVO1.setPetSex("公");
		//
		// dao.insert(PVO1);

		// 修改

		//
		// PetInformationVO PVO2 = new PetInformationVO();
		//
		// PVO2.setBreedNo(11);
		//
		// PVO2.setPetName("哈寶寶");
		// PVO2.setPetAge("幼年");
		// PVO2.setPetSize("小型");
		// PVO2.setPetColor("白");
		// PVO2.setPetPosition("台中市太平區中山路222號");
		// PVO2.setPetIc("無");
		// PVO2.setTNR("有");
		// PVO2.setSituation("現在是個超級健康寶寶，而且超可愛");
		// PVO2.setPetDate(new Date(new java.util.Date().getTime()));
		//
		// PVO2.setPetFilm(null);
		// PVO2.setPetTitle("超級黏人的狗狗");
		// PVO2.setPetLongitude(121.335654);
		// PVO2.setPetLatitude(25.153224);
		// PVO2.setPetSex("公");
		// PVO2.setPetNo(110);
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
	public Integer insert(PetInformationVO informationVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		Integer petNo = null;
		String[] cols = { "petNO" };
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(INSERT_SQL, cols);

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

			// getGeneratedKeys();取得主鍵值
			ResultSet rs = ps.getGeneratedKeys(); // 找到主鍵值
			ResultSetMetaData rsmd = rs.getMetaData(); //
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) { // 為什麼要跑迴圈，就是如果新增很多筆的時候，就需要去找到，但現在只有一筆，所以一定就只會有那筆
				do {
					for (int i = 1; i < columnCount; i++) {
						petNo = rs.getInt(i);
						System.out.println("自增主鍵值=" + petNo + "剛新增成功的動物編號");

					}
				} while (rs.next());
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return petNo;
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

			ps.setString(2, informationVO.getPetName());
			ps.setString(3, informationVO.getPetAge());
			ps.setString(4, informationVO.getPetSize());
			ps.setString(5, informationVO.getPetColor());
			ps.setString(6, informationVO.getPetPosition());
			ps.setString(7, informationVO.getPetIc());
			ps.setString(8, informationVO.getTNR());
			ps.setString(9, informationVO.getSituation());
			ps.setDate(10, informationVO.getPetDate());

			ps.setBytes(11, informationVO.getPetFilm());
			ps.setString(12, informationVO.getPetTitle());
			ps.setDouble(13, informationVO.getPetLongitude());
			ps.setDouble(14, informationVO.getPetLatitude());
			ps.setString(15, informationVO.getPetSex());
			ps.setInt(16, informationVO.getPetNo());

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

	@Override
	public List<PetInformationVO> getSupplyPet(Integer memNo) {
		List<PetInformationVO> list = new ArrayList<PetInformationVO>();
		// 回傳回來某會員曾送養過動物的list
		PetInformationVO petInfoVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_SUPPLY_PET);
			ps.setInt(1, memNo);
			rs = ps.executeQuery();

			while (rs.next()) {

				petInfoVO = new PetInformationVO();
				petInfoVO.setPetNo(rs.getInt("petNo"));
				petInfoVO.setStatus(rs.getString("status"));
				petInfoVO.setPetName(rs.getString("petName"));
				petInfoVO.setPetDate(rs.getDate("petDate"));
				petInfoVO.setPetTitle(rs.getString("petTitle"));
				list.add(petInfoVO);
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
		return list;

	}

	@Override
	public void comfirm(Integer memNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			ps = con.prepareStatement(COMFIRM_SQL);
			
			
			
			
			
			
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

}
