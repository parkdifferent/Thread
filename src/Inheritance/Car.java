package Inheritance;

/**
 * Created by tianf on 2016/8/23.
 */
public class Car extends Vehicle {

    protected String licensePlate = null;

    @Override
    public void setLicensePlate(String license) {
        super.setLicensePlate(license);
    }

    @Override
    public String getLicensePlate() {
        return super.getLicensePlate();
    }

    public void updateLicensePlate(String license){
        this.licensePlate = license;
    }
}
