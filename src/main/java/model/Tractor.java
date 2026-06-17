package model;

public class Tractor {


private String tractorName;
private String model;
private double rentPerDay;
private String status;
private String imageName;

public Tractor() {
}

public Tractor(String tractorName,
               String model,
               double rentPerDay,
               String status,
               String imageName) {

    this.tractorName = tractorName;
    this.model = model;
    this.rentPerDay = rentPerDay;
    this.status = status;
    this.imageName = imageName;
}

public String getTractorName() {
    return tractorName;
}

public void setTractorName(String tractorName) {
    this.tractorName = tractorName;
}

public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}

public double getRentPerDay() {
    return rentPerDay;
}

public void setRentPerDay(double rentPerDay) {
    this.rentPerDay = rentPerDay;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getImageName() {
    return imageName;
}

public void setImageName(String imageName) {
    this.imageName = imageName;
}


}
