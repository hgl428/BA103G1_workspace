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

import javax.servlet.http.HttpServletResponse;

public class PetImageDaoJDBC implements PetImageDao_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";

	private static final String INSERT_SQL = "insert into PetImage (picNo, petNo, petPicture, picName) values (picNo_seq.NEXTVAL,?,?,?)";
	private static final String UPDATE_SQL = "update PetImage set petPicture = ?, picName = ? where picNo = ?";
	private static final String DELETE_SQL = "delete from PetImage where picNo = ?";
	private static final String GET_ONE_SQL = "select * from PetImage where picNo = ?";
	private static final String GETALL_SQL = "select * from PetImage";
	private static final String GETPETPIC_SQL = "select petPicture from PetImage where petNo = ? ";

	public static void main(String[] args) {

		PetImageDaoJDBC dao = new PetImageDaoJDBC();

		
		
		 List<PetImageVO> list = dao.getPetPic(10);
		 
		 for(PetImageVO pic : list){
			 System.out.println(pic.getpetPicture());
		 }
		 	
			
			 

		// pvo.setPetNo(1);
		// pvo.setpetPicture(null);
		// pvo.setPicName("我是乖寶寶");
		//
		// dao.insert(pvo);

		//
		// PetImageVO pvo2 = new PetImageVO();
		//
		// pvo2.setpetPicture(null);
		// pvo2.setPicName("今天天氣很好");
		// pvo2.setPicNo(12);
		//
		// dao.update(pvo2);
		//
		// }

		// // �ק�
		// byte[] = null;
		// File file = new File("C:\\Users\\Java\\Desktop\\1.jpg");
		//
		// try {
		//
		// BufferedInputStream fis = new BufferedInputStream(new
		// FileInputStream(file)); //
		// byte[] buf = new byte[fis.available()]; //
		// int len; //
		// while ((len = fis.read(buf)) != -1) {
		// System.out.println(len);
		//
		// }
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// �R��
		// dao.delete(11);

		// FindByPK
//		PetImageVO PVO3 = dao.findByPK(9);
//
//		System.out.println(PVO3.getPetNo() + ",");
//		System.out.println(PVO3.getpetPicture() + ",");
//		System.out.println(PVO3.getPicNote() + ",");
//		System.out.println(PVO3.getPicName());

		// �d����

		// List<PetImageVO> list = dao.getAll();
		// for (PetImageVO pic : list) {
		// System.out.println(pic.getPicNo());
		// System.out.println(pic.getPetNo());
		// System.out.println(pic.getpetPicture());
		// System.out.println(pic.getPicNote());
		// System.out.println(pic.getPicName());
		// }

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
			ps.setString(3, imageVO.getPicName());

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
			ps.setString(2, imageVO.getPicName());
			ps.setInt(3, imageVO.getPicNo());

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

	@Override
	public List<PetImageVO> getPetPic(Integer petNo) {
		// TODO Auto-generated method stub
		List<PetImageVO> list = new ArrayList<PetImageVO>();

		PetImageVO imageVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GETPETPIC_SQL);
			ps.setInt(1, petNo);
			rs = ps.executeQuery();

			while (rs.next()) {

				imageVO = new PetImageVO();

				imageVO.setpetPicture(rs.getBytes("petPicture"));
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
