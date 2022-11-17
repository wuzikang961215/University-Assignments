class Functions{
    // Void method that print something
    public static void print(String word){
        System.out.println(word);
    }
    public static int square(int number){
        return number*number;
    }
    public static int getBigNumber(int number1, int number2){
        if(number1 > number2){
            return number1;
        }
        return number2;
    } 

    //function that sum the two numbers and return the sum
    private static float sum_numbers(float a, float b){
        float sum = a + b;
        return sum;
    }


    // main method
    public static void main(String [] args){
        //double x = 2, sq;
        //sq = Math.pow(x,2);
        //System.out.println("The square of " + x + " is "+sq);
        String s = "Finally my method is going to run...";
        print(s);
        int x = 4;
        int result = square(x);
        System.out.println("The square of " + x + " is "+result);

        int number1 = -3, number2 = -5;
        System.out.println("The biggest number is " + getBigNumber(number1,number2));
    
        float number01= 0f, number02 = 0f;
        for(int i=0 ; i<=5; i++){
            float a1 = 0.45f, a2 = 4.53f;
            number01 = number01 + a1;
            number02 = number02 + a2;
            a1 ++;
            a2 --;
            System.out.println("The sum is "+sum_numbers(number01, number02));
        }
        

    }
}