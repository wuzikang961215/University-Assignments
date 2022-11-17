import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Comparison{
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);
        System.out.print("Please, insert a number: ");
        // handle it when input is not an integer
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Sorry, you have to enter an integer");
            try {
                TimeUnit.SECONDS.sleep( 1 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Please, insert a number: ");
        }
        // the first number
        int number01 = input.nextInt();
        System.out.print("Please, insert a number: ");
        // handle it again when input is not an integer
        while(!input.hasNextInt()){
            input.next();
            System.out.println("Sorry, you have to enter an integer");
            try {
                TimeUnit.SECONDS.sleep( 1 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Please, insert a number: ");
        }
        // the second number
        int number02 = input.nextInt();

        // judging which number is bigger by conditions
        if(number01 > number02){
            System.out.println("The bigger number is "+number01);
        }
        else if(number01 < number02){
            System.out.println("The bigger number is "+number02);
        }
        // handle exception that two numbers are the same
        else{
            System.out.println("The two numbers are the same");
        }
    }
}