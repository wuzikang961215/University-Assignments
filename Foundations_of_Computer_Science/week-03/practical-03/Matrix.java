import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Matrix{
    public static void main(String[]args){
        System.out.println("Welcome to Matrix Determinant Calculator!");
        System.out.println("\nWould you like to calculate the determinant of a new matrix?");
        System.out.println("1. Yes, 2. No ");
        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        if(option==1){
            while(true){
                System.out.println("What is the dimension of the matrix? (Only enter 2 or 3)");
                int dimension = input.nextInt();
                // this is where the dimension is 2 or 3
                if(dimension == 2 || dimension == 3){
                    System.out.println("Your dimension of matrix is "+dimension+"x"+dimension);
                    try {
                        TimeUnit.SECONDS.sleep( 1 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\nGreat! Let's calculate this determinant then.");
                    System.out.println("\nPlease insert all the values for your matrix.\n");
                    
                    // creat an array to store all the values of matrix
                    int[][] matrix_value = new int[dimension][dimension];
                    // using for loop to store values
                    for(int i = 1; i<= dimension; i++){
                        for(int n = 1; n<= dimension; n++){
                            System.out.print("New matrix ["+i+"]["+n+"]: ");
                            int value = input.nextInt();
                            matrix_value[i-1][n-1] = value;                          
                        }
                    }
                    System.out.println("\nThe determinant of your matrix is:");
                    // using for loop to print matrix values in the right form
                    for(int i = 0; i<dimension; i++){
                        System.out.print("| ");
                        for(int x = 0; x<dimension; x++){
                            System.out.print(matrix_value[i][x]);
                            if(x<dimension-1){
                                System.out.print(", ");
                            }
                        }
                        System.out.println(" |");         
                    }
                    int determinant = 0;
                    // conditions for calculating determinant
                    if(dimension == 2){
                        determinant = matrix_value[dimension-2][dimension-2]*matrix_value[dimension-1][dimension-1]-matrix_value[dimension-2][dimension-1]*matrix_value[dimension-1][dimension-2];
                    }
                    else{
                        determinant = matrix_value[dimension-3][dimension-3]*matrix_value[dimension-2][dimension-2]*matrix_value[dimension-1][dimension-1]+matrix_value[dimension-3][dimension-2]*matrix_value[dimension-2][dimension-1]*matrix_value[dimension-1][dimension-3]+matrix_value[dimension-3][dimension-1]*matrix_value[dimension-2][dimension-3]*matrix_value[dimension-1][dimension-2]-matrix_value[dimension-3][dimension-1]*matrix_value[dimension-2][dimension-2]*matrix_value[dimension-1][dimension-3]-matrix_value[dimension-3][dimension-2]*matrix_value[dimension-2][dimension-3]*matrix_value[dimension-1][dimension-1]-matrix_value[dimension-3][dimension-3]*matrix_value[dimension-2][dimension-1]*matrix_value[dimension-1][dimension-2];
                    }
                    System.out.println("Determinant: "+determinant);

                    break;
                }
                // this is where the dimension is something other than 2 or 3
                else{
                    System.out.println("Sorry, you have to enter 2 or 3");
                    // wait a second and enter dimension again
                    try {
                        TimeUnit.SECONDS.sleep( 1 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // this is the option not wanting to calculate determinant of a matrix 
        else if(option==2){
            return;
        }        
    }
}