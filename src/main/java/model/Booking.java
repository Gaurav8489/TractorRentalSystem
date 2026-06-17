package model;

public class Booking {

    private int tractorId;
    private int bookingDays;
    private double totalRent;
    private int farmerId;
    private String bookingDate;

    public Booking() {
    }

    public Booking(int tractorId,
                   int bookingDays,
                   double totalRent,
                   int farmerId,
                   String bookingDate) {

        this.tractorId = tractorId;
        this.bookingDays = bookingDays;
        this.totalRent = totalRent;
        this.farmerId = farmerId;
        this.bookingDate = bookingDate;
    }

    public int getTractorId() {
        return tractorId;
    }

    public void setTractorId(int tractorId) {
        this.tractorId = tractorId;
    }

    public int getBookingDays() {
        return bookingDays;
    }

    public void setBookingDays(int bookingDays) {
        this.bookingDays = bookingDays;
    }

    public double getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(double totalRent) {
        this.totalRent = totalRent;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}