import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Challenges4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        while(true){
            try {

                //Make selection
                System.out.print("Available Commands:\n" +
                        "1. Get date\n" +
                        "2. Get age\n" +
                        "3. Get next birthday\n" +
                        "0. Quit\n" +
                        "Select Command: ");
                int choice = scan.nextInt();

                //Quit out
                if (choice == 0) {
                    System.out.println("\nSelected: Exit\nGoodbye...");
                    break;
                }

                //Date
                if (choice == 1) {
                    System.out.printf("%nSelected: Get date%n" +
                            "Date: %s%n" +
                            "Year: %d%n" +
                            "Month: %s%n" +
                            "Day: %d%n", date, date.getYear(), date.getMonth(), date.getDayOfMonth());
                    System.out.print("Enter to continue...");
                    scan.nextLine();
                    scan.nextLine(); //Consume \n after nextInt
                    System.out.println("Returning...\n");
                }

                //Age
                if (choice == 2) {
                    System.out.print("\nSelected: Get age\n" +
                            "Enter your birthday YYYY-MM-DD\n" +
                            "Birthday: ");
                    scan.nextLine(); //consume \n
                    try {
                        LocalDate bdate = LocalDate.parse(scan.nextLine());
                        //Calculate age
                        int age = date.getYear() - bdate.getYear();
                        LocalDate ndate = bdate.withYear(date.getYear());
                        if (ndate.isAfter(date))
                            age--;
                        //Output
                        System.out.println("You are " + age + " years old.");
                        System.out.print("Enter to continue..."); scan.nextLine();
                        System.out.println("Returning...\n");
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date. Please use YYYY-MM-DD.\nReturning...\n");
                    }
                }

                //Next BDay
                if (choice == 3) {
                    System.out.print("Selected: Get next birthday\n" +
                            "Enter your birthday YYYY-MM-DD\n" +
                            "Birthday: ");
                    scan.nextLine(); //consume \n
                    try {
                        LocalDate bdate = LocalDate.parse(scan.nextLine());
                        //Compare to this year's birthday,
                        //if it passed, compare it to next year's birthday
                        LocalDate ndate = bdate.withYear(date.getYear());
                        if (ndate.isBefore(date))
                            ndate = ndate.plusYears(1);
                        //Get days apart using ChronoUnit
                        long days = ChronoUnit.DAYS.between(date, ndate);
                        System.out.println("Your next birthday is " + days + " away.");
                        System.out.print("Enter to continue...");
                        scan.nextLine();
                        System.out.println("Returning...\n");
                    } catch(DateTimeParseException e){
                        System.out.println("Invalid date. Please use YYYY-MM-DD.\nReturning...\n");
                    }
                }

                //Out of range
                if (choice < 0 || choice > 3){
                    System.out.println("\nInput Out of Range\n" +
                            "Input a number from 0 to 3");}

            }
            catch(InputMismatchException e) {
                System.out.println("\nInput Mismatch\n" +
                        "Input a NUMBER from 0 to 3\n");
                scan.nextLine(); //Clear invalid input
            }
        }
    }
}
