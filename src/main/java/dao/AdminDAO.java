package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class AdminDAO {

    public int getTotalFarmers() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select count(*) from farmer";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getTotalTractors() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select count(*) from tractor";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getTotalBookings() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select count(*) from booking";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    public double getTotalRevenue() {

    	double revenue = 0;

    	try {

    	    Connection con =
    	            DBConnection.getConnection();

    	    String sql =
    	            "select sum(total_rent) from booking where status='Confirmed'";

    	    PreparedStatement ps =
    	            con.prepareStatement(sql);

    	    ResultSet rs =
    	            ps.executeQuery();

    	    if(rs.next()) {

    	        revenue =
    	                rs.getDouble(1);
    	    }

    	} catch(Exception e) {

    	    e.printStackTrace();
    	}

    	return revenue;
   

    	}

}