package model;

public class Farmer {

    private int farmerId;
    private String farmerName;
    private String mobile;
    private String village;
    private String password;

    public Farmer() {
    }

    public Farmer(String farmerName, String mobile,
                  String village, String password) {

        this.farmerName = farmerName;
        this.mobile = mobile;
        this.village = village;
        this.password = password;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}