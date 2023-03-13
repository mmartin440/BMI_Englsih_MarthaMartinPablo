/**************************************************************** *
 * File: Assignment 03
 * By: Martha Martin Pablo
 * Date: 03-06-2023
 * Description: This program ask me to give the user an option to what version of the
 * BMI they want, the users inputs their name, weight and height and low and high weight. With
 * that information I should display the user summaries and table of the inputs.
 * ****************************************************************/
import java.util.*;
public class BMI_MasterVersion_MarthaMartinPablo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calendar date = Calendar.getInstance();

        System.out.println("-".repeat(90));
        System.out.println("-- Welcome to:");
        System.out.printf("%-13s %s%n", "--","BODY MASS INDEX (BMI) Computation");
        System.out.printf("%-46s %s%n","--","by Martha Martin" );
        System.out.println("-".repeat(90));

        System.out.print("\nPlease enter full name: ");
        String fullName = input.nextLine();

        System.out.println("1 for English, Standard");
        System.out.println("2 for English, Professional");
        System.out.println("3 for Metric, Standard");
        System.out.println("4 for Metric, Professional");
        System.out.print("Please enter your choice: ");
        int userChoice = input.nextInt();

        if(userChoice == 1) {
            BMI_English(fullName, input);
        } else if(userChoice == 2) {
            BMI_English_PRO(fullName, input, date);
        } else if (userChoice == 3) {
            BMI_Metric(fullName, input);
        } else if(userChoice == 4) {
            BMI_Metric_PRO(fullName, input, date);
        } else {
            System.out.println("Sorry not a choice");
        }
    }


    public static void BMI_English(String fullName, Scanner input) {

        System.out.print("\nPlease enter height in feet and inches for " + fullName + ": ");
        int heightFt = input.nextInt();
        int heightIn = input.nextInt();
        System.out.print("Please enter weight in pounds for " + fullName + ": ");
        double weight = input.nextDouble();

        int totHeight = (heightFt*12)+ heightIn;
        double userBmi = (weight / Math.pow(totHeight, 2))*703;

        System.out.println("\n-- SUMMARY REPORT for " + fullName.toUpperCase());
        System.out.printf("-- BMI:\t\t\t\t   %f (or %.1f if rounded)\n", userBmi, userBmi);

        if( userBmi >= 30) {
            System.out.println("-- Weight Status:\t   Obesity");
        } else if (userBmi >= 25 ) {
            System.out.println("-- Weight Status:\t   Overweight");
        } else if (userBmi >=18.5) {
            System.out.println("-- Weight Status:\t   Healthy Weight");
        } else {
            System.out.println("-- Weight Status:\t   Underweight");
        }

        System.out.println("\nThe SFSU Mashouf Wellness Center is at 755 Font Blvd. \n");
        System.out.println("-".repeat(90));
        System.out.println("-- Thank you for using my program, " + fullName + "!");
        System.out.println("-".repeat(90));
    }
    public static void BMI_English_PRO(String fullName, Scanner input, Calendar date) {

        String stat;

        System.out.print("\nPlease enter height in feet and inches for " + fullName + ": ");
        int heightFt = input.nextInt();
        int heightIn = input.nextInt();
        System.out.print("Please enter weight in pounds for " + fullName + ": ");
        float weight = input.nextFloat();

        int totHeight = (heightFt*12)+ heightIn;
        double userBmi = (weight / Math.pow(totHeight, 2))*703;

        String thisFormat;

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

        System.out.printf("\n-- SUMMARY REPORT for %S%n" , fullName);
        System.out.format("-- Date and Time:\t   %tB %te, %tY at %tl:%tM:%tS %Tp%n", date, date, date, date, date, date, date);
        System.out.printf("-- BMI:\t\t\t\t   %f (or %.1f if rounded)%n", userBmi, userBmi);
        System.out.println("-- Weight Status:\t   " + stat);

        System.out.printf("%nPlease enter a LOW weight in pounds for %s: ", fullName);
        float low = input.nextFloat();
        System.out.printf("Please enter a HIGH weight in pounds for %s: ", fullName);
        float high = input.nextFloat();

        System.out.println("\n" + "-".repeat(55 ));
        System.out.printf("|  %-11s|  %-11s| %-23s |%n", "WEIGHT", "BMI", "WEIGHT STATUS");
        System.out.println(" " + "-".repeat(53 ));

        String currStat;
        double currBmi = 0;
        float currLow = low;
        String formatBMI = "";
        String lowStatus;
        String highStatus = "";

        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RESET = "\u001B[0m";

        while(currLow < high) {
            currBmi = (currLow / Math.pow(totHeight, 2))*703;

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

            if(currLow == low) {
                System.out.format("| % ,7.2f     |  " + formatBMI + "| " + lowStatus + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(LOW)" + ANSI_RESET + "  |%n", currLow, currBmi);
            } else {
                System.out.format("| % ,7.2f     |  " + formatBMI + "| "+ currStat + "|%n", currLow, currBmi);
            }

            if((currLow + 5.5) > weight && currLow <= weight) {
                System.out.printf("| % ,7.2f     |  " + formatBMI + "| " + stat + " (this)  " + thisFormat, weight, userBmi, "|");
            }
            currLow += 5.5;
        }
        System.out.format("| % ,7.2f     |  " + formatBMI + "| " + highStatus + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(HIGH)" + ANSI_RESET + "  |%n", high, currBmi);
        System.out.println("-".repeat(55 ));

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

    public static void BMI_Metric(String fullName, Scanner input) {


        System.out.print("\nPlease enter height in centimeter for " + fullName + ": ");
        int height = input.nextInt();
        System.out.print("Please enter weight in kilograms for " + fullName + ": ");
        double weight = input.nextDouble();

        double meterHeight = (height * .01);
        double userBmi = (weight / (meterHeight * meterHeight));

        System.out.println("\n-- SUMMARY REPORT for " + fullName.toUpperCase());
        System.out.printf("-- BMI:\t\t\t\t   %f (or %.1f if rounded)\n", userBmi, userBmi);

        if (userBmi >= 30) {
            System.out.println("-- Weight Status:\t   Obesity");
        } else if (userBmi >= 25) {
            System.out.println("-- Weight Status:\t   Overweight");
        } else if (userBmi >= 18.5) {
            System.out.println("-- Weight Status:\t   Healthy Weight");
        } else {
            System.out.println("-- Weight Status:\t   Underweight");
        }

        System.out.println("\nThe SFSU Mashouf Wellness Center is at 755 Font Blvd. \n");
        System.out.println("-".repeat(90));
        System.out.println("-- Thank you for using my program, " + fullName + "!");
        System.out.println("-".repeat(90));
    }

    public static void BMI_Metric_PRO(String fullName, Scanner input, Calendar date) {

        String stat;

        System.out.print("\nPlease enter height in centimeters for " + fullName + ": ");
        int height = input.nextInt();
        System.out.print("Please enter weight in kilograms for " + fullName + ": ");
        double weight = input.nextFloat();

        double meterHeight = (height * .01 );
        double userBmi = (weight / (meterHeight * meterHeight));

        String thisFormat;

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

        System.out.printf("\n-- SUMMARY REPORT for %S%n" , fullName);
        System.out.format("-- Date and Time:\t   %tB %te, %tY at %tl:%tM:%tS %Tp%n", date, date, date, date, date, date, date);
        System.out.printf("-- BMI:\t\t\t\t   %f (or %.1f if rounded)%n", userBmi, userBmi);
        System.out.println("-- Weight Status:\t   " + stat);

        System.out.printf("%nPlease enter a LOW weight in kilograms for %s: ", fullName);
        float low = input.nextFloat();
        System.out.printf("Please enter a HIGH weight in kilograms for %s: ", fullName);
        float high = input.nextFloat();

        System.out.println("\n" + "-".repeat(55 ));
        System.out.printf("|  %-11s|  %-11s| %-23s |%n", "WEIGHT", "BMI", "WEIGHT STATUS");
        System.out.println(" " + "-".repeat(53 ));

        String currStat;
        double currBmi = 0;
        float currLow = low;
        String formatBMI = "";
        String lowStatus;
        String highStatus = "";

        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RESET = "\u001B[0m";

        while(currLow < high) {

            currBmi = (currLow / (meterHeight * meterHeight));

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

            if(currLow == low) {
                System.out.format("| % ,7.2f     |  " + formatBMI + "| " + lowStatus + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(LOW)" + ANSI_RESET + "  |%n", currLow, currBmi);
            } else {
                System.out.format("| % ,7.2f     |  " + formatBMI + "| "+ currStat + "|%n", currLow, currBmi);
            }

            if((currLow + 2.5) > weight && currLow < weight) {
                System.out.printf("| % ,7.2f     |  " + formatBMI + "| " + stat + " (this)  " + thisFormat, weight, userBmi, "|");
            }
            currLow += 2.5;
        }
        System.out.format("| % ,7.2f     |  " + formatBMI + "| " + highStatus + ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(HIGH)" + ANSI_RESET + "  |%n", high, currBmi);
        System.out.println("-".repeat(55 ));

        System.out.println("\n\nThe SFSU Mashouf Wellness Center is at 755 Font Blvd.\n");
        System.out.println("-".repeat(90));
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

        System.out.println("-".repeat(90));
    }
}
