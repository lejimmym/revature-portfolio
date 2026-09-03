public class Challenges1 {
    public static void main(String[] args) {
        //Challenge 1
        System.out.println("Challenge - Hello World");
        System.out.println("Hello World!");
        //Challenge 2
        System.out.println("\nChallenge - Printing Output");
        int age = 28;
        double height = 5.6;
        String name = "Jimmy";
        System.out.printf("Name:%s, Age%d, Height:%.1f", name, age, height);
        //Challenge 3
        System.out.println("\nChallenge - Operators");
        int a = 20;
        int b = 10;
        System.out.println("Addition: "+(a+b));
        System.out.println("Subtraction: " +(a-b));
        System.out.println("Multiplication: " + (a*b));
        System.out.println("Division: "+ (a/b));
        System.out.println("Is a greater than b? "+ (a>b));
        System.out.println("Is a > b and b > 0? "+((a>b)&&(b>0)));
        
        //Challenge 4
        System.out.println("\nChallenge - Control Flow");
        int score = 75;
        char grade = 'B'; //???
        if (score >= 50){System.out.println("Passed");}
        if (score >= 90){System.out.println("A");}
        else if (score >=75){System.out.println("B");}
        else if (score >= 60){System.out.println("C");}
        else {System.out.println("D");}
        
        //Challenge 5
        System.out.println("\nChallenge - Loops");
        for(int i = 1; i<=5; i++){System.out.println("For Loop: " + i);}
        int j = 1;
        while(j <= 5){
            System.out.println("While Loop: " + j); 
            j++;
            }
        int k = 1;
        do{
            System.out.println("Do-While Loop: "+ k);
            k++;
        }while(k<=5);
        
        //Challenge 6
        System.out.println("\nChallenge - Calculator");
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";
        while(again.equals("y")){
            if (operator == '+'){System.out.println("Result: " + (num1+num2));}
            else if (operator == '-'){System.out.println("Result: " + (num1-num2));}
            else if (operator == '*'){System.out.println("Result: " + (num1*num2));}
            else if (operator == '/'){
                if (num2 == 0){
                    System.out.println("Cannot divide by zero");
                } else {System.out.println("Result: " + (num1/num2));}
            }
            again = "n";
        }        
    }
}