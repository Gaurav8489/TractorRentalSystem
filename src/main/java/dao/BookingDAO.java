package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Booking;
import util.DBConnection;

public class BookingDAO {

    public boolean bookTractor(Booking booking) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql =
            		"insert into booking(farmer_id,tractor_id,booking_days,total_rent,booking_date,status) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, booking.getFarmerId());
            ps.setInt(2, booking.getTractorId());
            ps.setInt(3, booking.getBookingDays());
            ps.setDouble(4, booking.getTotalRent());
            ps.setString(5, booking.getBookingDate());    
            ps.setString(6, "Confirmed");
            
            
            int row = ps.executeUpdate();

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
    public void viewBookings() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from booking";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("=================================");
            System.out.println("       BOOKING DETAILS");
            System.out.println("=================================");

            while(rs.next()) {
                System.out.println(
                    "Booking ID : " + rs.getInt("booking_id")
                    + " | Tractor ID : " + rs.getInt("tractor_id")
                    + " | Days : " + rs.getInt("booking_days")
                    + " | Total Rent : ₹" + rs.getDouble("total_rent")
                );
            }

            System.out.println("=================================");
            
            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public ResultSet getBookingsByFarmerId(int farmerId) {

        ResultSet rs = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "select * from booking where farmer_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, farmerId);

            rs = ps.executeQuery();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
    public boolean cancelBooking(int bookingId) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "update booking set status=? where booking_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, "Cancelled");
            ps.setInt(2, bookingId);

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
    public int getLastBookingId() {

        int bookingId = 0;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "select max(booking_id) as id from booking";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                bookingId =
                        rs.getInt("id");
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return bookingId;
    }
    
    public int getTractorIdByBookingId(int bookingId) {

        int tractorId = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "select tractor_id from booking where booking_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, bookingId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                tractorId = rs.getInt("tractor_id");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return tractorId;
    }
    
    
    public ResultSet getAllBookings() {

   
    	ResultSet rs = null;

    	try {

    	    Connection con =
    	            DBConnection.getConnection();
    	    String sql =
    	    		"select b.*, f.farmer_name, f.mobile " +
    	    		"from booking b " +
    	    		"join farmer f " +
    	    		"on b.farmer_id = f.farmer_id " +
    	    		"order by b.booking_id desc";


    	    PreparedStatement ps =
    	            con.prepareStatement(sql);

    	    rs = ps.executeQuery();

    	} catch(Exception e) {

    	    e.printStackTrace();
    	}

    	return rs;
    

    	}
    public ResultSet getReceiptDetails(int bookingId) {

    
    	ResultSet rs = null;

    	try {

    	    Connection con =
    	            DBConnection.getConnection();

    	    String sql =
    	    "select b.*, " +
    	    "f.farmer_name, f.mobile, " +
    	    "t.tractor_name, t.model, t.rent_per_day " +
    	    "from booking b " +
    	    "join farmer f on b.farmer_id = f.farmer_id " +
    	    "join tractor t on b.tractor_id = t.tractor_id " +
    	    "where b.booking_id=?";

    	    PreparedStatement ps =
    	            con.prepareStatement(sql);

    	    ps.setInt(1, bookingId);

    	    rs = ps.executeQuery();

    	} catch(Exception e) {

    	    e.printStackTrace();
    	}

    	return rs;
    

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

        } catch(Exception e) {
            e.printStackTrace();
        }

        return found;
    }

    
    
}