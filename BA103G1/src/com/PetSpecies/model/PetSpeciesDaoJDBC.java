package com.PetSpecies.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.PetSpecies.model.PetSpeciesDao_interface;
import com.PetSpecies.model.PetSpeciesVO;

public class PetSpeciesDaoJDBC implements PetSpeciesDao_interface {

	String DRIVER = "oracle.jdbc.driver.OracleDriver";

	String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	String USER = "BA103";
	String PASSWORD = "123456";

	private static final String INSERT_SQL = "INSERT INTO petSpecies values(speciesNo_SEQ.NEXTVAL,?)";
	private static final String GETALL_SQL = "select * from petSpecies";
	private static final String GET_ONE_SQL = "select * from petSpecies where speciesNo = ?";
	private static final String DELETE_SQL = "delete from petSpecies where speciesNo = ?";
	private static final String UPDATE_SQL = "update petSpecies set speciesName=? WHERE speciesNo=?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void insert(PetSpeciesVO petSpecies) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(INSERT_SQL);

			ps.setString(1, petSpecies.getSpeciesName());

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
	public void update(PetSpeciesVO speciesNo) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(UPDATE_SQL);

			ps.setString(1, speciesNo.getSpeciesName());
			ps.setInt(2, speciesNo.getSpeciesNo());

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
	public void delete(Integer speciesNo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			ps.setInt(1, speciesNo);
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
	public PetSpeciesVO findByPK(Integer speciesNo) {

		PetSpeciesVO speciesVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			ps.setInt(1, speciesNo);
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

		return speciesVO;
	}

	@Override
	public List<PetSpeciesVO> getAll() {

		List<PetSpeciesVO> list = new ArrayList<PetSpeciesVO>();
		PetSpeciesVO speciesVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				speciesVO = new PetSpeciesVO();

				speciesVO.setSpeciesNo(rs.getInt("speciesNo"));
				speciesVO.setSpeciesName(rs.getString("speciesName"));

				list.add(speciesVO);

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
