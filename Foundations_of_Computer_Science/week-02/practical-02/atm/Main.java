import java.util.Scanner;

class Main{
    public static void main(String [] args){
        System.out.print("Please enter an amount of cash: ");
        Scanner input = new Scanner(System.in);
        // Getting input
        int cash_amount = input.nextInt();
        // Running run function
        System.out.println(run(cash_amount));
    }

    public static String run(int amount){
        int X = 0, Y = 0;
        while(true){
            // How input can be divided by different values.
            if(amount >= 100){
                Y = Y + 2*(amount/100);
                amount = amount%100;  
            }
            else if(amount >= 80){
                X = 4*(amount/80);
                amount = amount%80;   
            }
            else if(amount >= 60){
                X = X + 3*(amount/60);
                amount = amount%60;  
            }
            else if(amount >= 50){
                Y = Y + amount/50;
                amount = amount%50;  
            }
            else if(amount >= 40){
                X = X + 2*(amount/40);
                amount = amount%40;   
            }
            else if(amount >= 20){
                X = X + amount/20;
                amount = amount%20; 
            }
            // If the input is 110, 130 or something similar and the calculation goes wrong, fix it in this way.
            else if(amount == 10){
                amount = amount + X*20 + Y*50 - 50;
                X = 0;
                Y = 1;
            }
            else{
                break;
            }  
        }
        // This is where the input can be withdrew.
        if(amount == 0){
            String a1 = String.valueOf(X);
            String a2 = String.valueOf(Y);
            return "Here is " + a1 + " $20 notes and " + a2 + " $50 notes.";   
        }
        // This is where the input cannot be withdrew.
        else{
            return "Sorry, the value you input cannot be withdrew.";
        }
    }
}