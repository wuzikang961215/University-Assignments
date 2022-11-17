import java.util.Scanner;

class Problem{
    public static void main(String [] args){
        System.out.print("Enter a distance in miles:");
        Scanner input = new Scanner(System.in);
        double M= input.nextDouble();
        if(M >= 0 && M <= 1000){
            double kms  = 1.6093 * M; 
            System.out.println("The distance in kilometres is "+ String.format("%.2f", kms)+" km");
        }
        else{
            System.out.println("The distance "+ M + " is out of range");
        }
    }
}