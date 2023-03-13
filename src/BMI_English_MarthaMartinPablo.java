/**************************************************************** *
 * File: Assignment 02
 * By: Martha Martin Pablo
 * Date: 02-06-2023
 * Description: [short description on what program does, what user
 * enters, what result(s) are displayed]
 * ****************************************************************/

// we import all the kind of dependecies ??? by using *
import java.util.*;
public class BMI_English_MarthaMartinPablo {
    public static void main(String[] args) {

        //intro
        System.out.println("-".repeat(90));
        System.out.println("-- Welcome to:");
        System.out.printf("%-13s %S\n", "--","BODY MASS INDEX (BMI) Computation, English version");
        System.out.printf("%-63s %S\n","--","by Martha Martin" );
        System.out.println("-".repeat(90));

        // I will create a variable that holds the input
        Scanner input = new Scanner(System.in);
        String fullName;
        int heightFt;
        int heightIn;
        double weight;

        // This asks for the user to enter their name
        System.out.print("\nPlease enter full name: ");
        // This is how it takes in the input which in this case is the name
        fullName = input.nextLine();
        // this ask for the height in ft and in
        System.out.print("Please enter height in feet and inches for " + fullName + ": ");
        //users input for height
        heightFt = input.nextInt();
        heightIn = input.nextInt();
        // this is where we can ask for the weight of the person
        System.out.print("Please enter weight in pounds for " + fullName + ": ");
        weight = input.nextDouble();

        // this where I do the calculations of the persons BMIn ( weight in kg / height in meters ^2 )
        System.out.println("\n-- SUMMARY REPORT for " + fullName.toUpperCase());

        // ill convert all the height in feet in inches to make it easier for cal cualtions
        int totHeight = (heightFt*12)+ heightIn;

        // used the formula that was give in example
        double userBmi = (weight / Math.pow(totHeight, 2))*703;
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
