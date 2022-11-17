import java.util.*;
public class Problem04{
    public static void main(String [] args){

        int sum = 0;
        for(int i=0 ; i<10 ; i++){
            Random ran = new Random();
            // Generating numbers no bigger than 20
            int number = ran.nextInt(21);
            System.out.print("Number (" + number + "): ");
            sum = sum + number;

            for(int x=0; x<number; x++){
                // Identifying numbers smaller than 10 and else as < and >=
                if ( number < 10){
                    System.out.print("<");
                }
                else{
                    System.out.print(">=");
                }
            }
            // Changing lines
            System.out.print("\n");
        }
        // Getting the mean of ten random numbers
        float mean = (float)sum/10;

        int average = Math.round(mean);
        System.out.print("Average (" + average + "): ");

        for(int i=0; i<average; i++){
            System.out.print("*");
        }
        System.out.print("\n");
    }
}