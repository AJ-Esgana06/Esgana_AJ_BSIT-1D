import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        String Username = "AJesgana";
        String Password = "AJesgana";
        boolean correctInput;
        System.out.println("Welcome to Calculator \nLogin First");
        do {
            String UserInput;
            System.out.println("Enter Username: ");
            UserInput = sc.next();
            correctInput = true;
            if (!UserInput.equals(Username)) {
                correctInput = false;
                System.out.println("Wrong Username! \nTry again: ");
            }
        } while (!correctInput);
        System.out.println("Correct!, \nNext is Password");
        do {
            String PassInput;
            System.out.println("Enter Password: ");
            PassInput = sc.next();
            correctInput = true;
            if (!PassInput.equals(Username)) {
                correctInput = false;
                System.out.println("Wrong Password! \nTry again: ");
            }
        } while (!correctInput);
        System.out.println("\nDone! ");
        boolean keepPlaying = true;
        while (keepPlaying) {
        do {
            System.out.println("\nEnter num1: ");
                double num1 = sc.nextDouble();
                System.out.println("Enter num2: ");
                double num2 = sc.nextDouble();
    
                System.out.println("Enter operator (+, -, *, /) ");
                char operator = sc.next().charAt(0);
                double result;
    
                switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0){
                        System.out.println("Error: Division by Zero");
                        continue;
                    } result = num1 / num2;
                      break;
                default:
                 System.out.println("Invalid operator");
                return;
    }
    System.out.println("\n" + num1 + " " + operator + " " + num2 + " " + "=" + " " + result);
        String answer;
        System.out.println("\nPlay again? (Y or N): ");
        answer = sc.next();
        if (answer.equalsIgnoreCase("Y")) {
        } else if (answer.equalsIgnoreCase("N")) {
        keepPlaying = false;
        } else
        correctInput = false;
            } while (!correctInput);
            System.out.println("\nThank you for Playing!");
        }
    }
}