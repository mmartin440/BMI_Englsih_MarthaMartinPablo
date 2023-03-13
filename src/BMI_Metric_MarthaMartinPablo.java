import java.util.Scanner;

/**************************************************************** *
 * File: Assignment 02
 * By: Martha Martin Pablo
 * Date: 02-016-2023
 * Description: [This program takes in user information and is able
 * to take the answer to display their BMI. THe user enters their
 * name, height in cm and weight in kg, the result that is displayed is there summary report.
 * ****************************************************************/
public class BMI_Metric_MarthaMartinPablo {

    public static void main(String[] args) {

        //intro
        System.out.println("-".repeat(90));
        System.out.println("-- Welcome to:");
        System.out.printf("%-13s %s\n", "--","BODY MASS INDEX (BMI) Computation, Metric version");
        System.out.printf("%-63s %s\n","--","by Martha Martin" );
        System.out.println("-".repeat(90));

        // I will create a variable that holds the input
        Scanner input = new Scanner(System.in);
        String fullName;
        int height;
        double weight;

        // This asks for the user to enter their name
        System.out.print("\nPlease enter full name: ");
        // This is how it takes in the input which in this case is the name
        fullName = input.nextLine();
        // this ask for the height in ft and in
        System.out.print("Please enter height in centimeter for " + fullName + ": ");
        //users input for height
        height = input.nextInt();
        // this is where we can ask for the weight of the person
        System.out.print("Please enter weight in kilograms for " + fullName + ": ");
        weight = input.nextDouble();

        System.out.println("\n-- SUMMARY REPORT for " + fullName.toUpperCase());
        // used the formula that was give in example
        double meterHeight = (height * .01 );
        double userBmi = (weight / (meterHeight * meterHeight));

        // in order to round you need to use %.?f ?= the amount you want to round
        System.out.printf("-- BMI:\t\t\t\t   %f (or %.1f if rounded)\n", userBmi, userBmi);
//        System.out.printf(" ( or %.1f%n if rounded)\n", userBmi);

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
}
