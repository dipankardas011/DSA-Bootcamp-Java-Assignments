import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        /**
         * Write a function to check if a given triplet is a Pythagorean triplet or not. (A Pythagorean
         * triplet is when the sum of the square of two numbers is equal to the square of the third number)
         */
        Scanner in = new Scanner(System.in);
        int a, b, c;
        System.out.println("Enter the number1: ");
        a = in.nextInt();
        System.out.println("Enter the number2: ");
        b = in.nextInt();
        System.out.println("Enter the number3: ");
        c = in.nextInt();



        if ((a * a + b * b == c * c)) {
            System.out.println("Pythagorean triplet");
        } else {
            System.out.println("Not Pythagorean triplet");
        }
    }
}
