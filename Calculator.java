import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        //Login page
       // System.out.println("Username: 'AJEsgana'");
        //System.out.println("password: '062006ajesgana'");
        String UserName = "AJEsgana";
        String Password = "062006ajesgana";
        
        System.out.println("Enter your Username: ");
       String UserNameInput = sc.next();
        if (UserNameInput.equals(UserName)) {
            System.out.println("Correct!");
                System.out.println("Enter your password: ");
            String PasswordInput = sc.next();
            if (PasswordInput.equals(Password)) {
                System.out.println("Welcome!");
                System.out.println("Enter num1: ");
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
        case '/':
            if (num2 == 0){
                System.out.println("Error: Division by Zero");
            } result = num1 / num2;
            break;
        default:
            System.out.println("Invalid operator");
            return;
    }
    
    System.out.println(num1 + " " + operator + " " + num2 + " " + "=" + " " + result);
            } else {
                System.out.println("Wrong password, Try again :)");
            }
            
        } else {
            System.out.println("Username not found, Try Again");
        }
    }
}