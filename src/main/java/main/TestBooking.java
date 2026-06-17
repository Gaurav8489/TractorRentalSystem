package main;

import dao.BookingDAO;

public class TestBooking {

    public static void main(String[] args) {

        BookingDAO dao = new BookingDAO();

        dao.viewBookings();
    }
}