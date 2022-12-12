package com.company;


import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String nameOfDriver;
    private String location;
    private int telNum;
    private int insuranceNum;
    private String carManufacturer;


    public Driver(String nameOfDriver, String carManufacturer, int carNumber, int numOfDrivers){

    }

    public Driver(String nameOfDriver,String carManufacturer){
        this.setNameOfDriver(nameOfDriver);
        this.setCarManufacturer(carManufacturer);
    }

    public Driver(String nameOfDriver,String carManufacturer,String location,int telNum,int insuranceNum){
        this.nameOfDriver=nameOfDriver;
        this.location=location;
        this.carManufacturer=carManufacturer;
        this.telNum=telNum;
        this.insuranceNum=insuranceNum;
    }

    protected Driver(String nameOfDriver, String carManufacturer, int carNumber, String location) {
    }

    protected Driver() {
    }

    protected Driver(String nameOfDriver){

    }

    @Override
    public String toString(){
        return "Driver's" +(  "Name is: "+ getNameOfDriver() + "\n"+ "Location is: "+ getLocation() + "\n"+ "Team Name: "+ getCarManufacturer() +"\n"+ "Telephone Number: "+ getTelNum() +"\n"+ "Insurance Number: "+ getInsuranceNum());
    }


    public String getNameOfDriver() {
        return nameOfDriver;
    }

    public void setNameOfDriver(String nameOfDriver) {
        this.nameOfDriver = nameOfDriver;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }

    public int getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(int insuranceNum) {
        this.insuranceNum = insuranceNum;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }
}
