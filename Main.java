import java.util.Scanner;

class Student {
    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;
    private int subjects;

    
    public Student(int subjects) {
        this.subjects = subjects;
        credits = new int[subjects];
        marks = new int[subjects];
    }

 
    public void acceptDetails(Scanner sc) {
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        
        System.out.println("Enter the credits and marks for each subject:");
        for (int i = 0; i < subjects; i++) {
            System.out.print("Credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

  
    public void displayDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Credits and Marks: ");
        for (int i = 0; i < subjects; i++) {
            System.out.println("Subject " + (i + 1) + " - Credits: " + credits[i] + ", Marks: " + marks[i]);
        }
        System.out.printf("SGPA: %.2f\n", calculateSGPA());
    }

   
    public double calculateSGPA() {
        int totalCredits = 0;
        int weightedMarksSum = 0;
        
        for (int i = 0; i < subjects; i++) {
            int gradePoint = getGradePoint(marks[i]);
            weightedMarksSum += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return (double) weightedMarksSum / totalCredits;
    }

  
    private int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0;  // Fail
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine(); // consume newline

       
        Student[] students = new Student[numStudents];

       
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            students[i] = new Student(numSubjects);
            students[i].acceptDetails(sc);
        }

        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nDetails of Student " + (i + 1) + ":");
            students[i].displayDetails();
        }

        sc.close();
    }
}
