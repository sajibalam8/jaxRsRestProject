package org.arpit.java2blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.arpit.java2blog.bean.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arpit.java2blog.hibernate.dao.SessionUtil;

public class CountryDao {

	  public static  boolean addCountry(Country c){
		    Session session = SessionUtil.getSession();    
		    Transaction tx = session.beginTransaction();
		    Country country = new Country();
		    
		    country.setId(c.getId());
		    country.setCountryName(c.getCountryName());
		    country.setPopulation(c.getPopulation());
		    
		    session.save(country);
		    tx.commit();
		    session.close();
			return true;
		    
		  }

	public static boolean udpateCountry(Country country) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int count = 0;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement("update public.\"Country\" set countryName=?,population =? where id=?");
			pst.setString(1, country.getCountryName());
			pst.setLong(2, country.getPopulation());
			pst.setInt(3, country.getId());
			count = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (count > 0) {
			status = true;
		}
		return status;
	}

	public static boolean deleteCountry(int id) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int count = 0;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement("delete from public.\"Country\"  where id=?");

			pst.setInt(1, id);

			count = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (count > 0) {
			status = true;
		}
		return status;
	}

	public static List<Country> getAllCountries() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Country> listOfCountries = new ArrayList<Country>();
		Country country;
		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			String sql = "select id, countryName, population from public.\"Country\"";
			System.out.println(sql);
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			try {
				while (rs.next()) {
					country = new Country();
					country.setId(rs.getInt(1));
					country.setCountryName(rs.getString(2));
					country.setPopulation(rs.getLong(3));
					listOfCountries.add(country);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return listOfCountries;
	}

	public static Country getCountry(int id) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Country country = new Country();

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement(" select id, countryName, population from public.\"Country\"  where id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();

			try {

				if (rs.next()) {
					country.setId(rs.getInt(1));
					country.setCountryName(rs.getString(2));
					country.setPopulation(rs.getLong(3));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (

		Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return country;
	}
}
