import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        if (a == 0) {
            if (b != 0) {
              
                double root = -c / b;
                System.out.println("This is a linear equation. The solution is: " + root);
            } else if (c == 0) {
             
                System.out.println("The equation has infinitely many solutions.");
            } else {
                
                System.out.println("The equation has no solutions.");
            }
        } else {
           
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The equation has two real solutions: " + root1 + " and " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                System.out.println("The equation has one real solution: " + root);
            } else {
                System.out.println("The equation has no real solutions.");
            }
        }

        input.close();
    }
}
