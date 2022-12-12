package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Formula1Driver extends Driver implements Serializable {

    static Scanner input= new Scanner(System.in);

    //private variables in Formula1Driver class
    private int currentPoints;
    private int noOfParticipatedRaces;
    private int firstPositionCount;
    private int secondPositionCount;
    private int thirdPositionCount;
    private String location;
    private int carNumber;
    private int position;
    private int date;

    public Formula1Driver(){

    }

    public Formula1Driver(String nameOfDriver){
        super(nameOfDriver);
    }

    public Formula1Driver(String nameOfDriver,String carManufacturer,int carNumber,String location){
        super(nameOfDriver,carManufacturer,carNumber,location);
    }


    //arg constructor
    public Formula1Driver(String nameOfDriver,int currentPoints,int noOfParticipatedRaces,int firstPositionCount,int secondPositionCount,int thirdPositionCount,int numOfDrivers,String carManufacturer,int carNumber,String location,int telNum,int insuranceNum,int date){

        super(nameOfDriver,carManufacturer,location,telNum,insuranceNum);
        this.setCurrentPoints(currentPoints);
        this.noOfParticipatedRaces=noOfParticipatedRaces;
        this.firstPositionCount=firstPositionCount;
        this.secondPositionCount=secondPositionCount;
        this.thirdPositionCount=thirdPositionCount;
        this.location=location;
        this.carNumber=carNumber;
        this.date=date;

    }



    //getters and setters


    public int getNoOfParticipatedRaces() {
        return noOfParticipatedRaces;
    }

    public void setNoOfParticipatedRaces(int noOfParticipatedRaces) {
        this.noOfParticipatedRaces = noOfParticipatedRaces;
    }


    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }



    @Override
    public String toString(){
        return "Formula1Driver"+("Number of participated races: "+noOfParticipatedRaces+"location: "+location+
                "Car Number: "+carNumber);
    }

    public int getFirstPositionCount() {
        return firstPositionCount;
    }

    public void setFirstPositionCount(int firstPositionCount) {
        this.firstPositionCount = firstPositionCount;
    }

    public int getSecondPositionCount() {
        return secondPositionCount;
    }

    public void setSecondPositionCount(int secondPositionCount) {
        this.secondPositionCount = secondPositionCount;
    }

    public int getThirdPositionCount() {
        return thirdPositionCount;
    }

    public void setThirdPositionCount(int thirdPositionCount) {
        this.thirdPositionCount = thirdPositionCount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }
}
