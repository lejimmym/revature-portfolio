import java.util.Scanner;
import java.lang.Math;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Challenges2 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        while(true) {
            System.out.printf("1. Challenge - Calculate 5 Test Scores\n" +
                    "2. Challenge - REPL\n" +
                    "0. Exit\n" +
                    "Select Challenge: ");
            choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("\nSelected: Exit\n" +
                        "Goodbye...");
                break;
            }
            if (choice == 1){
                System.out.println("\nSelected: Challenge - Calculate 5 Test Scores\n" +
                        "Input 5 Test Scores:");
                //Initiate Variables
                int total = 0;
                int[] score = new int[5];
                char[] grade = new char[5];
                int heighest = 0;
                int lowest = 100;
                //Loop 5 times to collect 5 scores
                for (int i = 0; i < score.length; i++) {
                    score[i] = scan.nextInt();
                    score[i] = Math.max(0, Math.min(score[i], 100)); //Clamp the score to a value between 0 and 100
                    total += score[i];
                    if (score[i] > heighest) {heighest = score[i];} //During looping calculate the heighest
                    if (score[i] < lowest) {lowest = score[i];}//During looping calculate the lowest
                    //Calculate grade
                    if (score[i] >= 90){grade[i] = 'A';}
                    else if (score[i] >=80){grade[i] = 'B';}
                    else if (score[i] >=70){grade[i] = 'C';}
                    else if (score[i] >=60){grade[i] = 'D';}
                    else {grade[i] = 'F';}
                }
                int average = total / 5;

                //Output
                System.out.printf("Total: %d%n" +
                        "Average: %d%n" +
                        "Highest: %d%n" +
                        "Lowest: %d%n%n" +
                        "Your values were:%n" +
                        "%d--%c%n" +
                        "%d--%c%n" +
                        "%d--%c%n" +
                        "%d--%c%n" +
                        "%d--%c%n%n" +
                        "Returning...%n%n",
                        total, average, heighest, lowest,
                        score[0], grade[0],
                        score[1], grade[1],
                        score[2], grade[2],
                        score[3], grade[3],
                        score[4], grade[4]);
            }
            if (choice == 2){
                System.out.println("\nSelected: Challenge - REPL");
                
            }
        }
    }
}