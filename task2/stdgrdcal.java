import java.util.Scanner;

public class stdgrdcal {

    public static void main(String args[]) {

        float subjectmarks[] = new float[8];     //array defined to storoe the marks of the subject
        int i;    
        float average;

        float totalmarks = 0;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);  //object for the scanner is defined

        System.out.print("Enter Marks Obtained in 8 Subjects: ");
        // Reading marks for 8 subjects
        for (i = 0; i < 8; i++) {    
            subjectmarks[i] = scanner.nextFloat();   // using for loop so to input the value of the marks of the subjects
        }

        
        for (i = 0; i < 8; i++) {
            totalmarks = totalmarks + subjectmarks[i];  //  the value is added for the totalmarks until the loop executes
        }

        
        average = totalmarks / 8;   //average masks calculated

        // Print grade based on the average
        System.out.println("\nTotal marks obtianed by the Student = " + totalmarks);
        System.out.println("\nAverage marks obtained by the Student = " + average);
        System.out.println("\nGrade of the student = ");

        if (average >= 80) {
            System.out.print("A");
        } else if (average >= 60 && average < 80) {     //using if else statement to determine the grade of the student
            System.out.print("B");
        } else if (average >= 40 && average < 60) {
            System.out.print("C");
        } else {
            System.out.print("D");
        }

        scanner.close(); 
    }
}


