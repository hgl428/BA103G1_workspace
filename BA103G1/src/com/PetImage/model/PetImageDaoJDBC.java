package com.PetImage.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetImageDaoJDBC implements PetImageDao_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle�X��
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";

	private static final String INSERT_SQL = "insert into PetImage(picNo, petNo,petPicture,picNote, picName) values (picNo_seq.NEXTVAL,?,?,?,?)";
	private static final String UPDATE_SQL = "update PetImage set petPicture=?,picNote=?,picName=? where picNo=?";
	private static final String DELETE_SQL = "delete from PetImage where picNo = ?";
	private static final String GET_ONE_SQL = "select petNo,petPicture,picNote,picName from PetImage where picNo =?";
	private static final String GETALL_SQL = "select * from PetImage";

	public static void main(String[] args) {

		PetImageDaoJDBC dao = new PetImageDaoJDBC();

		// �s�W
		 PetImageVO pvo = new PetImageVO();
		
		 pvo.setPetNo(3);
		 pvo.setpetPicture(null);
		 pvo.setPicNote("好可愛");
		 pvo.setPicName("最帥氣");
		
		 dao.insert(pvo);

		// �ק�
		byte[] buf = null; // ���ŧi�@��byte[]�Ŷ� buf
		File file = new File("C:\\Users\\Java\\Desktop\\�ʪ�����/cat07.png");

		try {
			// FileInputStream fis = new FileInputStream(file);
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file)); // �n��C����غc�l��J��������
			buf = new byte[fis.available()]; //���Dfis�쩳���h�֤� �N�Obuf
			int len; // ��������
			while ((len = fis.read(buf)) != -1) { //len�N�O����˨캡�N�˶i�h�A-1�N�O�o�@��Ū��=����˺�
				System.out.println(len);  //�̫�˧�fis=len���j�p;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		 PetImageVO pvo2 = new PetImageVO();
//		
//		 pvo2.setpetPicture(buf);
//		 pvo2.setPicNote("�W�Ϊ���");
//		 pvo2.setPicName("�a�ο�");
//		 pvo2.setPicNo(8);
//		
//		 dao.update(pvo2);

		// �R��
		// dao.delete(11);

//		 FindByPK
//		 PetImageVO PVO3 = dao.findByPK(9);
//		
//		 System.out.println(PVO3.getPetNo() + ",");
//		 System.out.println(PVO3.getpetPicture() + ",");
//		 System.out.println(PVO3.getPicNote() + ",");
//		 System.out.println(PVO3.getPicName());

		// �d����
		
		List<PetImageVO> list = dao.getAll();
		for (PetImageVO pic : list) {
			System.out.println(pic.getPicNo());
			System.out.println(pic.getPetNo());
			System.out.println(pic.getpetPicture());
			System.out.println(pic.getPicNote());
			System.out.println(pic.getPicName());
		}

	}

	@Override
	public void insert(PetImageVO imageVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(INSERT_SQL);

			ps.setInt(1, imageVO.getPetNo());
			ps.setBytes(2, imageVO.getpetPicture());
			ps.setString(3, imageVO.getPicNote());
			ps.setString(4, imageVO.getPicName());

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
	public void update(PetImageVO imageVO) {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(UPDATE_SQL);

			ps.setBytes(1, imageVO.getpetPicture());
			ps.setString(2, imageVO.getPicNote());
			ps.setString(3, imageVO.getPicName());
			ps.setInt(4, imageVO.getPicNo());

			ps.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	}

	@Override
	public void delete(Integer picNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(DELETE_SQL);

			ps.setInt(1, picNo);

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
	public PetImageVO findByPK(Integer picNo) {

		PetImageVO imageVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_ONE_SQL);
			ps.setInt(1, picNo);
			rs = ps.executeQuery();

			while (rs.next()) {

				imageVO = new PetImageVO();
				imageVO.setPetNo(rs.getInt("petNo"));
				imageVO.setpetPicture(rs.getBytes("petPicture"));
				imageVO.setPicNote(rs.getString("picNote"));
				imageVO.setPicName(rs.getString("picName"));
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

		return imageVO;
	}

	@Override
	public List<PetImageVO> getAll() {

		List<PetImageVO> list = new ArrayList<PetImageVO>();

		PetImageVO imageVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				imageVO = new PetImageVO();

				imageVO.setPicNo(rs.getInt("picNo"));
				imageVO.setPetNo(rs.getInt("petNo"));
				imageVO.setpetPicture(rs.getBytes("petPicture"));
				imageVO.setPicNote(rs.getString("picNote"));
				imageVO.setPicName(rs.getString("picName"));

				list.add(imageVO);
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

}
