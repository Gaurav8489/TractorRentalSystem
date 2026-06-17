package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Tractor;
import util.DBConnection;

public class TractorDAO {

	// Add Tractor
	public boolean addTractor(Tractor tractor) {

		boolean status = false;

		try {

		    Connection con =
		            DBConnection.getConnection();

		    String sql =
		    "insert into tractor(tractor_name,model,rent_per_day,status,image_name) values(?,?,?,?,?)";

		    PreparedStatement ps =
		            con.prepareStatement(sql);

		    ps.setString(1, tractor.getTractorName());
		    ps.setString(2, tractor.getModel());
		    ps.setDouble(3, tractor.getRentPerDay());
		    ps.setString(4, tractor.getStatus());
		    ps.setString(5, tractor.getImageName());

		    int row =
		            ps.executeUpdate();

		    if(row > 0) {
		        status = true;
		    }

		} catch(Exception e) {

		    e.printStackTrace();
		}

		return status;
		

		}


	// View All Tractors
	public void viewTractors() {

		try {

			Connection con = DBConnection.getConnection();

			String sql = "select * from tractor";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			System.out.println("========================================");
			System.out.println("         TRACTOR DETAILS");
			System.out.println("========================================");

			while (rs.next()) {

				System.out.println(
						rs.getInt("tractor_id") + " | " + rs.getString("tractor_name") + " | " + rs.getString("model")
								+ " | " + rs.getDouble("rent_per_day") + " | " + rs.getString("status"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete Tractor
	public boolean deleteTractor(int tractorId) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "delete from tractor where tractor_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, tractorId);

			int row = ps.executeUpdate();

			if (row > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Search Tractor By Name
	public ResultSet searchTractor(String tractorName) {

		ResultSet rs = null;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "select * from tractor where tractor_name=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, tractorName);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public boolean updateTractor(int tractorId, double rentPerDay, String statusValue) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "update tractor set rent_per_day=?, status=? where tractor_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, rentPerDay);
			ps.setString(2, statusValue);
			ps.setInt(3, tractorId);

			int row = ps.executeUpdate();

			if (row > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Update Tractor Status
	public boolean updateStatus(int tractorId) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String sql = "update tractor set status='Booked' where tractor_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, tractorId);

			int row = ps.executeUpdate();

			if (row > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public double getRentPerDay(int tractorId) {

	    double rent = 0;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	        "select rent_per_day from tractor where tractor_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, tractorId);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            rent =
	            rs.getDouble("rent_per_day");
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return rent;
	}
	public ResultSet getAllTractors() {

	    ResultSet rs = null;

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String sql =
	                "select * from tractor";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        rs = ps.executeQuery();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return rs;
	}
	
	public void makeAvailable(int tractorId) {

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String sql =
	        "update tractor set status='Available' where tractor_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, tractorId);

	        ps.executeUpdate();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public int getAvailableTractorCount() {

	    int count = 0;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	        "select count(*) from tractor where status='Available'";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            count = rs.getInt(1);
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return count;
	}
	public int getBookedTractorCount() {

	    int count = 0;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	        "select count(*) from tractor where status='Booked'";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            count = rs.getInt(1);
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return count;
	}
	public boolean isTractorExists(int tractorId) {

		
		boolean found = false;

		try {

		    Connection con =
		            DBConnection.getConnection();

		    String sql =
		    "select * from tractor where tractor_id=?";

		    PreparedStatement ps =
		            con.prepareStatement(sql);

		    ps.setInt(1, tractorId);

		    ResultSet rs =
		            ps.executeQuery();

		    if(rs.next()) {

		        found = true;
		    }

		    rs.close();
		    ps.close();
		    con.close();

		} catch(Exception e) {

		    e.printStackTrace();
		}

		return found;
	

		}

}