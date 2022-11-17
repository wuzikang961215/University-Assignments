import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class PrimeNumber{
    public static void main(String[]args){
        // asking for input
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("Please, insert a number: ");
            // using while loop to handle with wrong inputs
            while(!input.hasNextInt()){
                // enter again
                input.next();
                System.out.println("Sorry, you have to enter an integer");
                // making the program to wait a second before asking for input again
                try {
                    TimeUnit.SECONDS.sleep( 1 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("Please, insert a number: ");
            }
            int number = input.nextInt();

            // using conditions to distinguish between numbers
            if(number >= 3){
                int[] dividers = new int[number-2];
                int n = 0;
                // using while loop to divide input number
                while(n<number-2){
                    dividers[n]=n+2;
                    // if number can be divided by integers other than 1 and itself, than it is not prime
                    if(number%dividers[n]==0){
                        System.out.println("Your number is not prime");
                        break;
                    }
                    n++;
                }
                if(n == number-2){
                    number = number&dividers[n-1];
                }
                else{
                    number = number%dividers[n];
                }
                // judging if the number is prime
                if(number != 0){
                    System.out.println("Your number is prime");
                }  
                break;
            }
            
            // 2 is prime
            else if(number == 2){
                System.out.println("Your number is prime");
                break;
            }
            // 1 or else are neither prime nor composite
            else{
                System.out.println("Sorry, your number must be larger than 1");
            }

        }
        
            
        
    }
}