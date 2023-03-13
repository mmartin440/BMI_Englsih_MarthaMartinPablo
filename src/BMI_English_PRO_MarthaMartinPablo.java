/**************************************************************** *
 * File: Assignment 03
 * By: Martha Martin Pablo
 * Date: 02-23-2023
 * Description: [This program takes in user information and is able
 * to take the answer to display their BMI. THe user enters their
 * name, height in cm and weight in kg, the result that is displayed is there summary report.
 * ****************************************************************/

import java.util.Calendar;
import java.util.Scanner;
public class BMI_English_PRO_MarthaMartinPablo {

    public static void main(String[] args) {
        //intro at the Top
        System.out.println("-".repeat(90));
        System.out.println("-- Welcome to:");
        System.out.printf("%-13s %s%n", "--","BODY MASS INDEX (BMI) Computation, English version, PRO");
        System.out.printf("%-68s %s%n","--","by Martha Martin" );
        System.out.println("-".repeat(90));

        // declaring variable to use later in code for the current user
        Scanner input = new Scanner(System.in); // Take in inputs
        Calendar date = Calendar.getInstance(); // holding everything about today date
        String fullName; // declared an empty variable that can take a string
        int heightFt;
        int heightIn;
        float weight;
        String stat;

        // asking question and taking in inputs for each question
        System.out.print("Please enter full name: ");
        fullName = input.nextLine();
        System.out.print("Please enter height in feet and inches for " + fullName + ": ");
        heightFt = input.nextInt();
        heightIn = input.nextInt();
        System.out.print("Please enter weight in pounds for " + fullName + ": ");
        weight = input.nextFloat();

        // calculations for the BMI English version
        int totHeight = (heightFt*12)+ heightIn; // I convert the height in inches from the ft the users input
        double userBmi = (weight / Math.pow(totHeight, 2))*703;

        // declare a String for (this) format for later in our while loop
        String thisFormat;

        // If statement to calculate the stat of the user
        if( userBmi >= 30) {
            stat = "Obesity";
            thisFormat = "%9s%n";
        } else if (userBmi >= 25 ) {
            stat = "Overweight";
            thisFormat = "%6s%n";
        } else if (userBmi >=18.5) {
            stat = "Healthy Weight";
            thisFormat = "%2s%n";
        } else {
            stat = "Underweight";
            thisFormat = "%5s%n";
        }

        // this is the result of the users inputs
        System.out.printf("\n-- SUMMARY REPORT for %S%n" , fullName);
        System.out.format("-- Date and Time:\t   %tB %te, %tY at %tl:%tM:%tS %Tp%n", date, date, date, date, date, date, date);
        System.out.printf("-- BMI:\t\t\t\t   %f (or %.1f if rounded)%n", userBmi, userBmi);
        System.out.println("-- Weight Status:\t   " + stat);

        // will take in the low and high weight of user in pounds
        System.out.printf("%nPlease enter a LOW weight in pounds for %s: ", fullName);
        float low = input.nextFloat();
        System.out.printf("Please enter a High weight in pounds for %s: ", fullName);
        float high = input.nextFloat();

        // The header of table for all the Low and High weights
        // 15 spaces right at line, 14 right at line, 26 right at line
        // 14 at line, 14 at line, 25 at line
        System.out.println("-".repeat(55 ));
        System.out.printf("|  %-11s|  %-11s| %-23s |%n", "WEIGHT", "BMI", "WEIGHT STATUS");
        System.out.println(" " + "-".repeat(53 ));


        //declaring variable outside the while look so don't reset
        String currStat;
        double currBmi = 0;
        float currLow = low; // I made this onw starting at low first before we change it
        String formatBMI = "";
        String lowStatus;
        String highStatus = "";

        // to change the color for the low and high
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RESET = "\u001B[0m";

        // our loop will continue working until condition is no longer true
        while(currLow < high) {
            //calculate the constant changing BMI and Status
            currBmi = (currLow / Math.pow(totHeight, 2))*703;

            // we are setting the format for each
            if(currBmi >= 30) {
                currStat = "Obesity                 ";
                lowStatus = "Obesity          ";
                highStatus = "Obesity         ";
                formatBMI = "%-11.5f";
            } else if (currBmi >= 25 ) {
                currStat = "Overweight              ";
                lowStatus = "Overweight          ";
                highStatus = "Overweight      ";
                formatBMI = "%-11.4f";
            } else if (currBmi >=18.5) {
                currStat = "Healthy Weight          ";
                lowStatus = "Healthy Weight   ";
                highStatus = "Healthy Weight  ";
                formatBMI = "%-11.3f";
            } else {
                currStat = "Underweight             ";
                lowStatus ="Underweight      ";
                highStatus = "Underweight     ";
                formatBMI = "%-11.2f";
            }


            // we are using if statement to add LOW or HIGH or just print normal
            if(currLow == low) {
                System.out.format("| % ,7.2f     |  " + formatBMI + "| " + lowStatus + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(LOW)" + ANSI_RESET + "  |%n", currLow, currBmi);
            } else {
                System.out.format("| % ,7.2f     |  " + formatBMI + "| "+ currStat + "|%n", currLow, currBmi);
            }

            // we do an if statement
            if((currLow + 5.5) > weight && currLow <= weight) {
                    System.out.printf("| % ,7.2f     |  " + formatBMI + "| " + stat + " (this)  " + thisFormat, weight, userBmi, "|");
            }
            currLow += 5.5;
        }
        System.out.format("| % ,7.2f     |  " + formatBMI + "| " + highStatus + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(HIGH)" + ANSI_RESET + "  |%n", high, currBmi);
        System.out.println("-".repeat(55 ));

        // The bottom of the code
        System.out.println("\n\nThe SFSU Mashouf Wellness Center is at 755 Font Blvd.\n");
        System.out.println("-".repeat(70));
        System.out.println("-- Thank you for using my program, " + fullName + " !");

        if(fullName.equals("Baymax Hamada")) {
            System.out.println("-- Sayonara!!!");
        } else if(fullName.equals("Goofy Dog")) {
            System.out.println("-- Woof Woof!!!");
        } else if(fullName.equals("-- Minnie Mouse")) {
            System.out.println("-- Ear-esistable!!!");
        } else if(fullName.equals("Otto Minion")) {
            System.out.println("-- Poopaye!!!");
        } else {
            System.out.println("-- Bye!!!");
        }

        System.out.println("-".repeat(70));
    }
}


