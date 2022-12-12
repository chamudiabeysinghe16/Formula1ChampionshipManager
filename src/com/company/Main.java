package com.company;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        Formula1ChampionshipManager manager1 = new Formula1ChampionshipManager();

        //print out how many drivers are already registered.
        System.out.println("\n Number of drivers registered "+ manager1.getDriversArray().size());
        Formula1ChampionshipManager manager = new Formula1ChampionshipManager();


        Formula1Driver driver1 = new Formula1Driver();
        while (true) {
            System.out.println("\n");

            System.out.println("*** Welcome to Racing Car Competition!!! *** \n");
            System.out.println("Enter 1- Add New Driver");
            System.out.println("Enter 2- Delete a Driver");
            System.out.println("Enter 3- Change the Driver for an Existing Constructor Team");
            System.out.println("Enter 4- Display Various Statistics");
            System.out.println("Enter 5- Display the FORMULA 1 DRIVER Table");
            System.out.println("Enter 6- Add Races Completed");
            System.out.println("Enter 7- Show Information");
            System.out.println("Enter 8- Open UserInterface");
            System.out.println("Enter 9- EXIT");
            System.out.println("*---Enter Your Selection---*");

            Scanner input = new Scanner(System.in);
            String choice = input.next();

            if (choice.equals("9")) {
                break;
            }
            else {
                switch (choice) {
                    case "1":{

                        System.out.println("<--- ADD NEW DRIVER ---> \n");
                        manager.addNewDriver(driver1.getNameOfDriver(), driver1.getCarManufacturer(),driver1.getCarNumber(),driver1.getLocation());
                        manager.saveInformation();

                        //Print out how many drivers are already registered
                        System.out.println("Number of clubs registered " + manager.getDriversArray().size());
                        break;
                    }

                    case "2":{
                        System.out.println("<--- DELETE A DRIVER --->");
                        manager.deleteDriver();
                        //To save new updated data.
                        manager.saveInformation();
                        break;
                    }

                    case "3":{
                        System.out.println(" ");
                        System.out.println("<--- CHANGE THE DRIVER FOR A SELECTED EXISTING DRIVER --->");
                        manager.changeDriver();
                        manager.saveInformation();
                        break;
                    }

                    case "4":{
                        System.out.println("");
                        System.out.println("<--- SHOW STATISTICS --->");
                        manager.showStatistics();
                        break;
                    }

                    case "5":{
                        System.out.println("");
                        System.out.println("<--- FORMULA 1 DRIVER TABLE --->");
                        System.out.println("");
                        manager.displayFormula1DriverTable();
                        System.out.println(" ");
                        System.out.println(" ");
                        manager.saveInformation();
                        break;
                    }

                    case "6":{
                        System.out.println("");
                        System.out.println("<--- RACES COMPLETED --->");
                        System.out.println("\nEnter the race date(YYYY-MM-DD) :");
                        String dateString=input.next();
                        LocalDate date=LocalDate.parse(dateString);
                        LinkedList<Integer> positionArrayList=new LinkedList<>();
                        System.out.println("\n Enter the positions for following drivers.\n");

                        for(Formula1Driver formula1Driver:manager.getDriversArray()){
                            System.out.println(formula1Driver.getNameOfDriver()+ " : ");
                            int position=input.nextInt();
                            positionArrayList.add(position);
                        }

                        System.out.println("");
                        manager.addRaceCompleted(positionArrayList);
                        manager.saveInformation();
                        break;
                    }

                    case "7":{
                        System.out.println("<--- INFORMATION --->");
                        manager.getInfo();
                        break;
                    }

                    case "8":{
                        System.out.println("<--- OPEN UserInterface --->");
                        new UserInterface();
                        manager.saveInformation();
                        break;

                    }
                    default:
                        System.out.println("*** Invalid input ***");
                        break;


                    }

                    }
            }

    }

}




