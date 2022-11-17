import java.util.*;
public class Problem01{
    public static void main(String [] args){

        for(int i=0 ; i<10 ; i++){
            Random ran = new Random();
            // Generating numbers no bigger than 20
            int number = ran.nextInt(21);
            System.out.print("Number (" + number + "): ");

            // Printing out stars using loop
            for(int x=0; x<number; x++){
                System.out.print("*");
            }
            // Changing lines
            System.out.print("\n");
        }
    }
}