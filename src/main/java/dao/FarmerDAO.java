package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Farmer;
import util.DBConnection;

public class FarmerDAO {

	public boolean registerFarmer(Farmer farmer) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "insert into farmer(farmer_name,mobile,village,password) values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, farmer.getFarmerName());
			ps.setString(2, farmer.getMobile());
			ps.setString(3, farmer.getVillage());
			ps.setString(4, farmer.getPassword());

			int row = ps.executeUpdate();

			if (row > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public int getFarmerIdByMobile(String mobile) {

		int farmerId = 0;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "select farmer_id from farmer where mobile=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mobile);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				farmerId = rs.getInt("farmer_id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return farmerId;
	}

	public ResultSet getAllFarmers() {

		ResultSet rs = null;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "select * from farmer";

			PreparedStatement ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}
	// Login Method

	public boolean loginFarmer(String mobile, String password) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "select * from farmer where mobile=? and password=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mobile);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public Farmer getFarmerByMobile(String mobile) {

		Farmer farmer = null;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "select * from farmer where mobile=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mobile);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				farmer = new Farmer();

				farmer.setFarmerId(rs.getInt("farmer_id"));

				farmer.setFarmerName(rs.getString("farmer_name"));

				farmer.setMobile(rs.getString("mobile"));

				farmer.setVillage(rs.getString("village"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return farmer;
	}

	public boolean changePassword(String mobile, String oldPassword, String newPassword) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "update farmer set password=? where mobile=? and password=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, newPassword);
			ps.setString(2, mobile);
			ps.setString(3, oldPassword);

			int row = ps.executeUpdate();

			if (row > 0) {

				status = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return status;
	}
	public boolean updatePassword(
			String mobile,
			String password) {

		
			boolean status = false;

			try {

			    Connection con =
			            DBConnection.getConnection();

			    String sql =
			            "update farmer set password=? where mobile=?";

			    PreparedStatement ps =
			            con.prepareStatement(sql);

			    ps.setString(1, password);
			    ps.setString(2, mobile);

			    int row =
			            ps.executeUpdate();

			    if(row > 0) {

			        status = true;
			    }

			    ps.close();
			    con.close();

			} catch(Exception e) {

			    e.printStackTrace();
			}

			return status;
			

			}

}