import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Challenges4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        while(true){
            System.out.print("Available Commands:\n" +
                    "1. Get date\n" +
                    "2. Get age\n" +
                    "3. Get next birthday\n" +
                    "0. Quit\n" +
                    "Select Command: ");
            int choice = scan.nextInt();
            if (choice == 0){System.out.println("Goodbye..."); break;}
            if (choice == 1){
                System.out.printf("%nSelected: Get date%n" +
                        "Date: %s%n" +
                        "Year: %d%n" +
                        "Month: %s%n" +
                        "Day: %d%n",date, date.getYear(), date.getMonth(), date.getDayOfMonth());
                System.out.print("Enter to continue..."); scan.nextLine(); scan.nextLine();
                System.out.println("\nReturning...\n");
            }
            if (choice == 2){
                System.out.print("\nSelected: Get age\n" +
                        "Enter your birthday YYYY-MM-DD\n" +
                        "Birthday: ");
                scan.nextLine(); //consume \n
                LocalDate bdate = LocalDate.parse(scan.nextLine());
                int age = date.getYear() - bdate.getYear();

                //Did the month and day of your birthday pass yet?
                if ((date.getMonthValue() < bdate.getMonthValue())
                        && (date.getDayOfMonth() < bdate.getDayOfMonth()))
                            age--;
                System.out.println("You are " + age + " years old.");
                System.out.print("Enter to continue..."); scan.nextLine();
                System.out.println("\nReturning...\n");
            }
            if (choice == 3){
                System.out.print("Selected: Get next birthday\n" +
                        "Enter your birthday YYYY-MM-DD\n" +
                        "Birthday: ");
                scan.nextLine(); //consume \n
                LocalDate bdate = LocalDate.parse(scan.nextLine());
                //Compare to this year's birthday,
                //if it passed, compare it to next year's birthday
                LocalDate ndate = bdate.withYear(date.getYear());
                if (ndate.isBefore(date))
                    ndate = ndate.plusYears(1);
                //Get days apart using ChronoUnit
                long days = ChronoUnit.DAYS.between(date, ndate);
                System.out.println("Your next birthday is " + days + " away.");
                System.out.print("Enter to continue..."); scan.nextLine();
                System.out.println("\nReturning...\n");

            }
        }
    }
}
