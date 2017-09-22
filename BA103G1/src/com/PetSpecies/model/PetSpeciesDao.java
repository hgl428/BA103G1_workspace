package com.PetSpecies.model;

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

public class PetSpeciesDao implements PetSpeciesDao_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_SQL = "INSERT INTO petSpecies values(speciesNo_SEQ.NEXTVAL,?)";
	private static final String GETALL_SQL = "select * from petSpecies";
	private static final String GET_ONE_SQL = "select * from petSpecies where speciesNo = ?";
	private static final String DELETE_SQL = "delete from petSpecies where speciesNo = ?";
	private static final String UPDATE_SQL = "update petSpecies set speciesName = ? WHERE speciesNo = ?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(PetSpeciesVO petSpecies) {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(INSERT_SQL);

			ps.setString(1, petSpecies.getSpeciesName());

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
	public void update(PetSpeciesVO petSpecies) {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(UPDATE_SQL);

			ps.setString(1, petSpecies.getSpeciesName());
			ps.setInt(2, petSpecies.getSpeciesNo());

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
	public void delete(Integer speciesNo) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = ds.getConnection();

			ps.setInt(1, speciesNo);
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
	public PetSpeciesVO findByPK(Integer speciesNo) {

		
		PetSpeciesVO speciesVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			ps = con.prepareStatement(GET_ONE_SQL);
			ps.setInt(1,speciesNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				speciesVO = new PetSpeciesVO();

				speciesVO.setSpeciesNo(rs.getInt("speciesNo"));
				speciesVO.setSpeciesName(rs.getString("speciesName"));

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

			con = ds.getConnection();
			ps = con.prepareStatement(GETALL_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				speciesVO = new PetSpeciesVO();

				speciesVO.setSpeciesNo(rs.getInt("speciesNo"));
				speciesVO.setSpeciesName(rs.getString("speciesName"));

				list.add(speciesVO);

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
