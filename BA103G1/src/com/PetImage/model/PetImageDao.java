package com.PetImage.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PetImageDao implements PetImageDao_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_SQL = "insert into PetImage (picNo, petNo, petPicture, picName) values (picNo_seq.NEXTVAL,?,?,?)";
	private static final String UPDATE_SQL = "update PetImage set petPicture = ?, picName = ? where picNo = ?";
	private static final String DELETE_SQL = "delete from PetImage where picNo = ?";
	private static final String GET_ONE_SQL = "select petPicture from PetImage where picNo = ?";
	private static final String GETALL_SQL = "select petPicture from PetImage";
	private static final String GETPETPIC_SQL = "select petPicture from PetImage where petNo = ? ";

	// public static void main(String[] args) {
	//
	// PetImageDao dao = new PetImageDao();
	//
	// // �s�W
	// PetImageVO pvo = new PetImageVO();
	//
	// pvo.setPetNo(3);
	// pvo.setpetPicture(null);
	// pvo.setPicNote("好可愛");
	// pvo.setPicName("最帥氣");
	//
	// dao.insert(pvo);
	// }
	@Override
	public void insert(PetImageVO imageVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = ds.getConnection();
			ps = con.prepareStatement(INSERT_SQL);

			ps.setInt(1, imageVO.getPetNo());
			ps.setBytes(2, imageVO.getpetPicture());
			ps.setString(3, imageVO.getPicName());

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
	public void update(PetImageVO imageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_SQL);

			pstmt.setBytes(1, imageVO.getpetPicture());
			pstmt.setString(2, imageVO.getPicName());
			pstmt.setInt(3, imageVO.getPicNo());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
			con = ds.getConnection();
			ps = con.prepareStatement(DELETE_SQL);

			ps.setInt(1, picNo);

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
	public PetImageVO findByPK(Integer picNo) {

		PetImageVO imageVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(GET_ONE_SQL);
			ps.setInt(1, picNo);
			rs = ps.executeQuery();

			while (rs.next()) {

				imageVO = new PetImageVO();

				imageVO.setpetPicture(rs.getBytes("petPicture"));

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
			con = ds.getConnection();
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				imageVO = new PetImageVO();

				imageVO.setpetPicture(rs.getBytes("petPicture"));

				list.add(imageVO);
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
		// 	一對多，一隻動物會有多圖
		List<PetImageVO> list = new ArrayList<PetImageVO>();

		PetImageVO imageVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(GETPETPIC_SQL);
			ps.setInt(1, petNo);
			rs = ps.executeQuery();

			while (rs.next()) {

				imageVO = new PetImageVO();

				imageVO.setpetPicture(rs.getBytes("petPicture"));

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
