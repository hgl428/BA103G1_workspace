package com.PetBreed.model;

import java.sql.*;
import java.util.*;

import com.PetImage.model.PetImageVO;

public class PetBreedDaoJDBC implements PetBreedDao_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // oracle�X��
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "BA103";
	private static final String PASSWORD = "123456";

	private static final String INSERT_SQL = "insert into PetBreed values (petBreed_seq.NEXTVAL,?,?)";
	private static final String UPDATE_SQL = "update PetBreed set BreedName=? where breedNo = ?";
	private static final String DELETE_SQL = "delete from PetBreed where breedNo = ?";
	private static final String GET_ONE_SQL = "select * from PetBreed where breedNo = ?";
	private static final String GETALL_SQL = "select * from PetBreed";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetBreedDaoJDBC dao = new PetBreedDaoJDBC();
		
		
		
		
		
//		PetBreedVO PVO3 = dao.findOneByPK(1);
//		System.out.println(PVO3.getBreedName() + ",");
//		System.out.println(PVO3.getSpeciesNo());
		// �s�W
		// PetBreedVO pvo = new PetBreedVO();
		//
		// pvo.setBreedName("�w�w�s");
		// pvo.setSpeciesNo(60);
		//
		// dao.insert(pvo);
		//
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
//		PetBreedVO PVO3 = dao.findOneByPK(8);
//		
//		 System.out.println(PVO3.getBreedName());
//		 System.out.println(PVO3.getSpeciesNo());
		//
		// // �d����

		 List<PetBreedVO> list = dao.getAll();
		 for (PetBreedVO breed : list) {
		 System.out.println(breed.getBreedNo());
		 System.out.println(breed.getBreedName());
		 System.out.println(breed.getSpeciesNo());
		
		 }
	}

	@Override
	public void insert(PetBreedVO breed) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(INSERT_SQL);

			ps.setString(1, breed.getBreedName());
			ps.setInt(2, breed.getSpeciesNo());

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
	public void update(PetBreedVO breed) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(UPDATE_SQL);

			ps.setString(1, breed.getBreedName());
			ps.setInt(2, breed.getSpeciesNo());

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
	public void delete(Integer breedNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			ps.setInt(1, breedNo);
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
	public PetBreedVO findOneByPK(Integer breedNo) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PetBreedVO petBreedVO = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

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
		} catch (ClassNotFoundException e) {
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
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				breedVO = new PetBreedVO();

				breedVO.setBreedNo(rs.getInt("breedNo"));
				breedVO.setBreedName(rs.getString("breedName"));
				breedVO.setSpeciesNo(rs.getInt("speciesNo"));

				list.add(breedVO);
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
