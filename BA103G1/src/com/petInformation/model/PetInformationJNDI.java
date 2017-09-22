package com.petInformation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PetInformationJNDI implements PetInformationDao_interface {
	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_SQL = "INSERT INTO petInformation (petNo,memNo,breedNo,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petFilm,petTitle,petLongitude,petLatitude,petSex)VALUES (petInformation_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // 使用者能輸入的地方，第一次要進資料庫
	private static final String UPDATE_SQL = "Update petInformation set breedNo = ?, status = ?, petName = ?, petAge = ?, petSize = ?, petColor = ?, petPosition = ?,"
			+ "petIc = ?, TNR = ?, situation = ?, petFilm = ?, petTitle = ?, petSex = ? where petNo = ?";
	private static final String DELETE_SQL = "delete from PetInformation where petNo = ?";
	private static final String GET_ONE_SQL = "select memNo,breedNo,status,petName,petAge,petSize,petColor,petPosition,petIc,TNR,situation,petDate,petFilm,petTitle,pexSex from Petinformation where petNo = ?";
	private static final String GETALL_SQL = "select * from petInformation order by petNo DESC";


//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		PetInformationJNDI dao = new PetInformationJNDI();
//
//		// �s�W
//		PetInformationVO PVO1 = new PetInformationVO();

	
//
//		 PVO1.setMemNo(333333);
//		 PVO1.setBreedNo(10);
//		 PVO1.setStatus("�e�i��");
//		 PVO1.setPetName("�Ѥ�");
//		 PVO1.setPetAge("��");
//		 PVO1.setPetSize("��");
//		 PVO1.setPetColor("��");
//		 PVO1.setPetPosition("��饫���c�Ϥ�����300��");
//		 PVO1.setPetIc("��");
//		 PVO1.setTNR("�L");
//		 PVO1.setSituation("�ּ֪����o�F");
//		 PVO1.setPetDate(null); // �n�εo���U���ɶ�
//		 PVO1.setMemNo2(111); // ��i�H
//		 PVO1.setPetFilm(null);
//		 PVO1.setPetTitle("�v�W�L�ĥi�R");
//		 PVO1.setPetLongitude(0.0);
//		 PVO1.setPetLatitude(0.0);
//		 PVO1.setPetSex("��");
//		
//		 dao.insert(PVO1);

		// �ק�
		// PetInformationVO PVO2 = new PetInformationVO();
		//
		// PVO2.setBreedNo(11);
		// PVO2.setStatus("�f�֤�");
		// PVO2.setPetName("���N");
		// PVO2.setPetAge("��");
		// PVO2.setPetSize("�p");
		// PVO2.setPetColor("��");
		// PVO2.setPetPosition("�x�����ӥ��Ϥ��s��111��");
		// PVO2.setPetIc("�L");
		// PVO2.setTNR("��");
		// PVO2.setSituation("�{�b�O�ӶW�Ű��d�_�_�A�ӥB�W�i�R");
		// PVO2.setPetFilm(null);
		// PVO2.setPetTitle("�W���H�H������");
		// PVO2.setPetNo(10);
		//
		// dao.update(PVO2);
		//
		// // �R��
		//
		// dao.delete(11);
		//
		// �d�߬Y�@�ʪ�
//		 PetInformationVO PVO3 = dao.findByPK(2);
//		
//		 System.out.println(PVO3.getMemNo() + ",");
//		 System.out.println(PVO3.getBreedNo() + ",");
//		 System.out.println(PVO3.getStatus() + ",");
//		 System.out.println(PVO3.getPetName() + ",");
//		 System.out.println(PVO3.getPetAge() + ",");
//		 System.out.println(PVO3.getPetSize() + ",");
//		 System.out.println(PVO3.getPetColor() + ",");
//		 System.out.println(PVO3.getPetPosition() + ",");
//		 System.out.println(PVO3.getPetIc() + ",");
//		 System.out.println(PVO3.getTNR() + ",");
//		 System.out.println(PVO3.getSituation() + ",");
//		 System.out.println(PVO3.getPetDate() + ",");
//		 System.out.println(PVO3.getPetFilm() + ",");
//		 System.out.println(PVO3.getPetTitle() + ",");

		// // �d�ߥ���
		//
//		List<PetInformationVO> list = dao.getAll();
//		for (PetInformationVO get : list) {
//			System.out.println(get.getPetNo() + ",");
//			System.out.println(get.getMemNo() + ",");
//			System.out.println(get.getBreedNo() + ",");
//			System.out.println(get.getStatus() + ",");
//			System.out.println(get.getPetName() + ",");
//			System.out.println(get.getPetAge() + ",");
//			System.out.println(get.getPetSize() + ",");
//			System.out.println(get.getPetColor() + ",");
//			System.out.println(get.getPetPosition() + ",");
//			System.out.println(get.getPetIc() + ",");
//			System.out.println(get.getTNR() + ",");
//			System.out.println(get.getSituation() + ",");
//			System.out.println(get.getPetDate() + ",");
//			System.out.println(get.getMemNo2() + ",");
//			System.out.println(get.getPetFilm() + ",");
//			System.out.println(get.getPetTitle() + ",");
//			System.out.println();
//
//		}
//
//	}

	@Override
	public void insert(PetInformationVO informationVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(INSERT_SQL);

			ps.setInt(1, informationVO.getMemNo());
			ps.setInt(2, informationVO.getBreedNo());
			ps.setString(3, informationVO.getStatus());
			ps.setString(4, informationVO.getPetName());
			ps.setString(5, informationVO.getPetAge());
			ps.setString(6, informationVO.getPetSize());
			ps.setString(7, informationVO.getPetColor());
			ps.setString(8, informationVO.getPetPosition());
			ps.setString(9, informationVO.getPetIc());
			ps.setString(10, informationVO.getTNR());
			ps.setString(11, informationVO.getSituation());
			ps.setDate(12, informationVO.getPetDate());
			ps.setInt(13, informationVO.getMemNo2());
			ps.setBytes(14, informationVO.getPetFilm());
			ps.setString(15, informationVO.getPetTitle());
			ps.setDouble(16, informationVO.getPetLongitude());
			ps.setDouble(17, informationVO.getPetLatitude());

			ps.executeUpdate();

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

			con = ds.getConnection();
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
			ps.setInt(13, informationVO.getPetNo());

			ps.executeUpdate();

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

			con = ds.getConnection();
			ps = con.prepareStatement(DELETE_SQL);

			ps.setInt(1, petNo);

			ps.executeUpdate();

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

			con = ds.getConnection();
			ps = con.prepareStatement(GET_ONE_SQL);
			ps.setInt(1, petNo); // �N�O�Ĥ@�Ӱݸ��Apk���s��

			// �M�����檺���G��JResultSet��
			rs = ps.executeQuery();
			// ��rs�̭����F��@�Ӥ@�Ӽ��X�ӡA�A�q�X
			while (rs.next()) {
				// �����l��
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

			}

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

		return informationVO; // �O�ѤF�^��VO���骫��(KEY����W��)
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
			con = ds.getConnection();
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

				list.add(informationVO);
			}

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
