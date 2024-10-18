import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.println("Enter grade no. 1");
        double grade1 = sc.nextDouble();
        System.out.println("Enter grade no. 2");
        double grade2 = sc.nextDouble();
        System.out.println("Enter grade no. 3");
        double grade3 = sc.nextDouble();
        System.out.println(gradeChecker(grade1, grade2, grade3));
    }
    public static String gradeChecker(double grade1, double grade2, double grade3) {
        double average = (grade1 + grade2 + grade3) / 3;
        if (average >= 85) {
            return "Passed: " + average;
        }
        else {
            return "Failed: " + average;
        }
    }
}