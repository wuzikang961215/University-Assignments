import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserInterface{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        // Using while loop to perform operation
        while(true){

            // Making the program to wait a second before starting to offer a better experience
            try {
                TimeUnit.SECONDS.sleep( 1 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print(" Welcome dear user! \n Would you like to: \n a) sum again \n b) exit \n Option: ");
            // Getting choice input as Strings
            String option = input.next(), choice1 = "a" , choice2 = "b" ;
            
            // Using if statements to judge among a, b and other inputs
            if(option.equals(choice1)){
                System.out.print("\n Please, insert the first number: ");
                int first_number = input.nextInt();

                System.out.print(" Please, insert the second number: ");
                int second_number = input.nextInt();

                int sum = first_number + second_number;
                
                // Printing out the numbers and sum
                System.out.println(" ---- \n Thank you for your enquiry, the sum between "+first_number+" and "+second_number+" is "+sum+"\n");
            }
            else if(option.equals(choice2)){
                System.out.println("\n Thank you! Have a good day.\n");
                // Stopping the while loop here
                break;
            }
            else{
                // If inputs are not a or b, continue the loop and ask the user to enter again
                System.out.println("\n Please enter a or b. \n");
            }
        }
    }
}