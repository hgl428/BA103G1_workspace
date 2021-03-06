package com.PetBreed.model;

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

public class PetBreedDao implements PetBreedDao_interface {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_SQL = "insert into PetBreed values (petBreed_seq.NEXTVAL,?,?)";
	private static final String UPDATE_SQL = "update PetBreed set BreedName = ? where breedNo = ?";
	private static final String DELETE_SQL = "delete from PetBreed where breedNo = ?";
	private static final String GET_ONE_SQL = "select * from PetBreed where breedNo = ?";
	private static final String GETALL_SQL =  "select * from PetBreed";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetBreedDao dao = new PetBreedDao();

		// �s�W
//		PetBreedVO pvo = new PetBreedVO();
//
//		pvo.setBreedName("麻雀");
//		pvo.setSpeciesNo(40);
//
//		dao.insert(pvo);

		// �ק�
		// PetImageVO pvo2 = new PetImageVO();
		//
		// pvo2.setPicNote("�W�Ϊ���");
		// pvo2.setPicName("�a�ο�");
		// pvo2.setPicNo(8);
		//
		// dao.update(pvo2);

		// �R��
		// dao.delete(11);

		// FindByPK
//		PetBreedVO PVO3 = dao.findOneByPK(10);
//		
//		
//		 System.out.println(PVO3.getBreedName() + ",");
//		 System.out.println(PVO3.getSpeciesNo());
	
		//
		// // �d����

		// List<PetImageVO> list = dao.getAll();
		// for (PetImageVO pic : list) {
		// System.out.println(pic.getPicNo());
		// System.out.println(pic.getPetNo());
		// System.out.println(pic.getPicture());
		// System.out.println(pic.getPicNote());
		// System.out.println(pic.getPicName());
		// }
	}

	@Override
	public void insert(PetBreedVO breed) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(INSERT_SQL);

			ps.setString(1, breed.getBreedName());
			ps.setInt(2, breed.getSpeciesNo());

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
	public void update(PetBreedVO breed) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(UPDATE_SQL);

			ps.setString(1, breed.getBreedName());
			ps.setInt(2, breed.getSpeciesNo());

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
	public void delete(Integer breedNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = ds.getConnection();

			ps.setInt(1, breedNo);
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
	public PetBreedVO findOneByPK(Integer breedNo) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PetBreedVO petBreedVO = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(GET_ONE_SQL);
			ps.setInt(1, breedNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				petBreedVO = new PetBreedVO();

				petBreedVO.setBreedName(rs.getString("breedName"));
				petBreedVO.setSpeciesNo(rs.getInt("speciesNo"));
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

		return petBreedVO;
	}

	@Override
	public List<PetBreedVO> getAll() {
		List<PetBreedVO> list = new ArrayList<PetBreedVO>();

		PetBreedVO breedVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				breedVO = new PetBreedVO();

				breedVO.setBreedNo(rs.getInt("breedNo"));
				breedVO.setBreedName(rs.getString("breedName"));
				breedVO.setSpeciesNo(rs.getInt("speciesNo"));

				list.add(breedVO);
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
