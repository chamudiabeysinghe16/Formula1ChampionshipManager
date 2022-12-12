package com.company;


import java.io.Serializable;
import java.time.LocalDate;

public class RaceCompleted implements Serializable {
    //private variables of playedMatch class
    private String teamName;
    private String driverName;
    private int position;
    private int currentPoints;
    private int firstPositionCount;
    private int secondPositionCount;
    private int thirdPositionCount;
    private int numOfDrivers;
    private int noOfParticipatedRaces;


    public RaceCompleted(){
        //default constructor
    }


    //Args constructor
    public RaceCompleted(String teamName, String driverName, int position,int currentPoints,int firstPositionCount,int secondPositionCount, int thirdPositionCount, int numOfDrivers, int noOfParticipatedRaces) {
        this.setTeamName(teamName);
        this.driverName=driverName;
        this.position=position;
        this.currentPoints=currentPoints;
        this.firstPositionCount=firstPositionCount;
        this.secondPositionCount=secondPositionCount;
        this.thirdPositionCount=thirdPositionCount;
        this.numOfDrivers=numOfDrivers;
        this.noOfParticipatedRaces=noOfParticipatedRaces;

    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public int getNumOfDrivers() {
        return numOfDrivers;
    }

    public void setNumOfDrivers(int numOfDrivers) {
        this.numOfDrivers = numOfDrivers;
    }

    public int getNoOfParticipatedRaces() {
        return noOfParticipatedRaces;
    }

    public void setNoOfParticipatedRaces(int noOfParticipatedRaces) {
        this.noOfParticipatedRaces = noOfParticipatedRaces;
    }
}
