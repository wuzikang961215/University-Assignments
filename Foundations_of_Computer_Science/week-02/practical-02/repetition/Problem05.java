import java.util.*;
public class Problem05{
    public static void main(String [] args){

        int sum = 0;
        for(int i=0 ; i<10 ; i++){
            Random ran = new Random();
            // Generating numbers no bigger than 20
            int number = ran.nextInt(21);
            System.out.print("Number (" + number + "): ");
            sum = sum + number;
            
            // Printing out marks using while loop
            int x=0; 
            while(x<number){
                // Using switch statements to identify the different ranges
                switch (number){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        System.out.print("o");
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        System.out.print("x");
                        break;
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        System.out.print("s");
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        System.out.print("*");
                        break;
                }
                x++;
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