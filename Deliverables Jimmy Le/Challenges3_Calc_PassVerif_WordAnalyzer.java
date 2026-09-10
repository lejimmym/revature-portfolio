import java.util.Scanner;

public class Challenges3 {
    public static boolean isVowel(char ch){
        String vowels = "AEIOUaeiou";
        //If indexOf fails it returns -1
        return vowels.indexOf(ch) != -1;
    }
    public static boolean isConstanant(char ch){
        String constanant = "QWRTYPSDFGHJKLZXCVBNMqwrtypsdfghjklzxcvbnm";
        return constanant.indexOf(ch) != -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;

        //I'm not using a switch to take advantage of break; in a while loop.
        while(true) {
            System.out.print("Available Commands:\n" +
                    "1. Add\n" +
                    "2. Subtract\n" +
                    "3. Multiply\n" +
                    "4. Divide\n" +
                    "5. Random\n" +
                    "6. Reverse\n" +
                    "7. Password Validator\n" +
                    "8. Word Analyzer\n" +
                    "0. Quit\n" +
                    "Select Command: ");
            choice = scan.nextInt();
            if (choice == 0){System.out.println("\nSelected: Quit\nGoodbye..."); break;}
            if (choice == 1){
                System.out.print("\nSelected: Add\n" +
                        "First number: ");
                int val1 = scan.nextInt();
                System.out.print("Second number: ");
                int val2 = scan.nextInt();
                System.out.print("Result: " + (val1 + val2));
                System.out.print("\nEnter to continue..."); scan.nextLine();scan.nextLine();
            }
            if (choice == 2){
                System.out.print("\nSelected: Subtract\n" +
                        "First number: ");
                int val1 = scan.nextInt();
                System.out.print("Second number: ");
                int val2 = scan.nextInt();
                System.out.print("Result: " + (val1 - val2));
                System.out.print("\nEnter to continue..."); scan.nextLine();scan.nextLine();
            }
            if (choice == 3){
                System.out.print("\nSelected: Multiply\n" +
                        "First number: ");
                int val1 = scan.nextInt();
                System.out.print("Second number: ");
                int val2 = scan.nextInt();
                System.out.print("Result: " + (val1 * val2));
                System.out.print("\nEnter to continue..."); scan.nextLine();scan.nextLine();
            }if (choice == 4){
                System.out.print("\nSelected: Divide\n" +
                        "First number: ");
                int val1 = scan.nextInt();
                System.out.print("Second number: ");
                int val2 = scan.nextInt();
                System.out.print("Result: " + (val1 / val2));
                System.out.print("\nEnter to continue..."); scan.nextLine();scan.nextLine();
            }if (choice == 5){
                System.out.print("\nSelected: Random\n" +
                        "Minimum: ");
                int val1 = scan.nextInt();
                System.out.print("Maximum: ");
                int val2 = scan.nextInt();
                System.out.print("Result: " + (int)(val1 + Math.random() * (val2 - val1)));
                System.out.print("\nEnter to continue..."); scan.nextLine();scan.nextLine();
            }if (choice == 6){
                System.out.print("\nSelected: Reverse\n" +
                        "Enter text: ");
                //Consume the \n after nextInt
                scan.nextLine();
                String string = scan.nextLine();
                String reversed = "";
                //Loop to reverse string
                for (int i = string.length() -1; i >= 0; i--){
                    reversed += string.charAt(i);
                }
                System.out.print("Reversed: " + reversed);
                System.out.print("\nEnter to continue..."); scan.nextLine();
            }if (choice == 7){
                System.out.print("\nSelected: Password Validator\n" +
                        "Please enter a password with at least 8 characters, one uppercase, one lowercase, and a number\n" +
                        "Password: ");
                //Consume the \n
                scan.nextLine();
                String password = scan.nextLine();

                boolean[] checks = new boolean[4];

                //Run checks
                checks[0] = password.length() >= 8;
                for(char c : password.toCharArray()){
                    if(!checks[1]) {checks[1] = Character.isUpperCase(c);}
                    if(!checks[2]) {checks[2] = Character.isLowerCase(c);}
                    if(!checks[3]) {checks[3] = Character.isDigit(c);}
                }
                //Output failures
                if(!checks[0]) {System.out.println("Length is too short");}
                if(!checks[1]) {System.out.println("Missing uppercase letter");}
                if(!checks[2]) {System.out.println("Missing lowercase letter");}
                if(!checks[3]) {System.out.println("Missing a number");}
                //Output success
                if (checks[0] && checks[1] && checks[2] && checks[3]){System.out.println("Password Validation Successful");}
                System.out.print("\nEnter to continue..."); scan.nextLine();

            }if (choice == 8){
                System.out.print("\nSelected: Word Analyzer\n" +
                        "Word: ");
                //Consume the \n
                scan.nextLine();
                String word = scan.nextLine();
                int characters = word.length();
                int vowels = 0;
                int consonants = 0;
                int digits = 0;
                int spaces = 0;

                //Analyze characters
                for(char c : word.toCharArray()){
                    if(isVowel(c)) {vowels++;}
                    if(isConstanant(c)) {consonants++;}
                    if(Character.isDigit(c)) {digits++;}
                    if(Character.isSpaceChar(c)) {spaces++;}
                }

                //Output
                System.out.printf("%nCharacters: %d%n" +
                        "Vowels: %d%n" +
                        "Consonants: %d%n" +
                        "Digits: %d%n" +
                        "Space: %d%n%n", characters, vowels, consonants, digits, spaces);
                System.out.print("\nEnter to continue..."); scan.nextLine();

            }
            System.out.println(" ");
        }
    }
}