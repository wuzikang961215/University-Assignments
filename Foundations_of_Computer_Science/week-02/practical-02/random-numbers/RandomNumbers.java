import java.util.*;

public class RandomNumbers {
    public static void main(String [] args){

        int sum = 0;

        for(int i = 1; i <= 10; i++){

            Random ran = new Random();
            // Generating random integers larger than 0 and less than 20
            int number = ran.nextInt(20);
            sum = sum + number; 
            // Printing out each random interger
            System.out.println(" Number " + i + " = " + number );
        }
        // Printing out the sum of random integers
        System.out.println("\n The sum of ten random integers = " + sum);
        float mean = (float)sum/10;
        // Printing out the mean of random integers
        System.out.println(" The mean of ten random integers = " + mean);
    }
}