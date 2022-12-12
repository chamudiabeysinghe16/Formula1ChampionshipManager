package com.company;

import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager,Serializable {


    Scanner input= new Scanner(System.in);
    public static LinkedList<Formula1Driver> driversArray = new LinkedList<Formula1Driver>();
    public static LinkedList<RaceCompleted> racesArray = new LinkedList<>();


    public Formula1ChampionshipManager() {

    }

    public Formula1ChampionshipManager(LinkedList<RaceCompleted> raceArrayListGUI, LinkedList<Formula1Driver> teamArrayListGUI) {
        this.racesArray = raceArrayListGUI;
        this.driversArray = teamArrayListGUI;
    }


    //get driversArray method
    public static LinkedList<Formula1Driver> getDriversArray() {
        return driversArray;
    }

    //get racesArray method
    public LinkedList<RaceCompleted> getRacesArray() {
        return racesArray;
    }

    //method for adding a new driver for Formula1Driver
    @Override
    public void addNewDriver(String nameOfDriver, String carManufacturer, int carNumber, String location) {

        Formula1Driver driver = new Formula1Driver(nameOfDriver, carManufacturer, carNumber, location);


        Scanner input = new Scanner(System.in);
        System.out.print("Enter driver's name: ");
        String driverName = input.next();

        System.out.print("Enter Team name: ");
        String teamName = input.next();

        System.out.print("Car number: ");
        int carNum = input.nextInt();

        System.out.print("location: ");
        location = input.next();


        while (true) {
            if (teamName.equals(driver)) {
                System.out.println("This team name is take. Please re-enter!!!");
                teamName = input.next();

            } else {
                break;
            }
        }

        System.out.println(" ");
        System.out.print("New Driver Added Successfully. \n");

        driver.setCarManufacturer(teamName);
        driver.setNameOfDriver(driverName);
        driver.setLocation(location);
        driver.setCarNumber(carNum);

        //To add all the drivers to the drivers array
        driversArray.add(driver);
    }

    //method for deleting existing driver
    @Override
    public boolean deleteDriver() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter driver's name: ");
        String driversName = input.nextLine();

        boolean flag = false;

        for (Formula1Driver driver : driversArray) {
            if (driversName.equals(driver.getNameOfDriver())) {
                flag = true;

                //To remove that club form the array
                driversArray.remove(driver);
                System.out.println(" ");
                System.out.println("*** Driver " + driver.getNameOfDriver() + " is successfully deleted ***");
                break;
            }
        }
        if (!flag) {
            System.out.println("<<< No such driver in driver list >>>");
        }
        return flag;
    }


    @Override
    public void changeDriver() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter current team name: ");
        String teamName = input.next();

        for (Formula1Driver driver : driversArray) {
            if (driver.getCarManufacturer().equals(teamName)) {
                System.out.print("Enter the new team name for the existing constructor: ");
                String newTeamName = input.next();

                String driverName = driver.getNameOfDriver();
                driver.setCarManufacturer(newTeamName);

                System.out.println("Driver's name is " + driverName + " and new team is " + newTeamName);

            }
        }
    }

    //method to show statistics
    @Override
    public void showStatistics() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter team name: ");
        String teamName = input.next();

        for (Formula1Driver driver : driversArray) {
            if (driver.getCarManufacturer().equals(teamName)) {

                System.out.println("Team " + driver.getCarManufacturer() + " - current points: " + driver.getCurrentPoints());
                System.out.println("Team " + driver.getCarManufacturer() + " - number of participated races: " + driver.getNoOfParticipatedRaces());
                System.out.println("Team " + driver.getCarManufacturer() + " - number of first positions: " + driver.getFirstPositionCount());
                System.out.println("Team " + driver.getCarManufacturer() + " - number of second positions: " + driver.getSecondPositionCount());
                System.out.println("Team " + driver.getCarManufacturer() + " - number of third positions: " + driver.getThirdPositionCount());
                System.out.println("Team " + driver.getCarManufacturer() + " - location: " + driver.getLocation());
                System.out.println("Team " + driver.getCarManufacturer() + " - car manufacturer: " + driver.getCarManufacturer());
                System.out.println("Team " + driver.getCarManufacturer() + " - car number: " + driver.getCarNumber());
                break;
            } else {
                System.out.println("No such team");
            }
        }

    }

    //Display the Formula1 Driver Table
    @Override
    public void displayFormula1DriverTable() {
        Collections.sort(driversArray, new PointComparator());

        //To print the table columns
        System.out.printf("%-20s%-20s%-30s%-30s%-30s%-30s%-30s\n",
                "Car Manufacturer", "Car Number", "Number of participated races",
                "First position count", "Second position count", "Third position count", "Current points");

        for (Formula1Driver driver : driversArray) {
            //To print table data
            System.out.printf("%-20s%-20d%-30d%-30d%-30d%-30d%-30d\n",
                    driver.getCarManufacturer(), driver.getCarNumber(), driver.getNoOfParticipatedRaces(), driver.getFirstPositionCount(), driver.getSecondPositionCount(), driver.getThirdPositionCount(),
                    driver.getCurrentPoints());
        }

    }


//method to add races completed
   @Override
   public void addRaceCompleted(LinkedList<Integer> positionArrayList) {
       LinkedList<Integer> positionList;
       positionList = positionArrayList;
       int position;
       Formula1Driver formula1Driver;
       for (int i = 0; i < getDriversArray().size(); i++) {
           position = positionList.get(i);
           formula1Driver = driversArray.get(i);

           switch (position) {
               case 1:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 25);
                   formula1Driver.setFirstPositionCount(formula1Driver.getFirstPositionCount() + 1);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 2:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 18);
                   formula1Driver.setSecondPositionCount(formula1Driver.getSecondPositionCount() + 1);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 3:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 15);
                   formula1Driver.setThirdPositionCount(formula1Driver.getThirdPositionCount() + 1);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 4:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 12);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 5:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 10);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 6:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 8);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 7:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 6);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 8:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 4);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 9:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 2);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;

               case 10:
                   formula1Driver.setCurrentPoints(formula1Driver.getCurrentPoints() + 1);
                   formula1Driver.setNoOfParticipatedRaces(formula1Driver.getNoOfParticipatedRaces() + 1);
                   formula1Driver.setLocation(formula1Driver.getLocation());
                   formula1Driver.setCarNumber(formula1Driver.getCarNumber());
                   break;
           }
       }

       System.out.println("");
       System.out.println("<-- Completed races added -->");

   }
    @Override
    public void saveInformation() {

        try {
            FileOutputStream file = new FileOutputStream("/Users/chamudi/Desktop/CourseworkOOP(Intellij) 2 2 3 2 2/Championship Details.txt");
            ObjectOutputStream save = new ObjectOutputStream(file);
            save.writeObject(driversArray);
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println("<--- Changes are Saved --->");

    }


    //Get info method
    public void getInfo() throws FileNotFoundException {
        File newFile = new File("/Users/chamudi/Desktop/CourseworkOOP(Intellij) 2 2 3 2 2/Championship Details.txt");

        if (newFile.length() == 0) {
            System.out.println("<--- No Data to Load --->");
        } else {


            try {
                FileInputStream file = new FileInputStream("/Users/chamudi/Desktop/CourseworkOOP(Intellij) 2 2 3 2 2/Championship Details.txt");
                ObjectInputStream save = new ObjectInputStream(file);
                driversArray = (LinkedList<Formula1Driver>) save.readObject();
                save.close();

            } catch (Exception exc) {
                exc.printStackTrace();
            }
            System.out.println("<--- Data Loaded --->");
        }


    }

}







