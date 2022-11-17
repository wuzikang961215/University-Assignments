import java.util.Random;
class Temperatures{
    public static void main(String[] args){
        Random rand = new Random();
        int year = 10;
        //0-10 degress
        int [] temp1 = new int[year];
        int index1=0;
        //11-20 degrees
        int [] temp2 = new int[year];
        int index2=0;
        //21-30 degrees
        int [] temp3 = new int[year];
        int index3=0;
        //31-40 degrees
        int [] temp4 = new int[year];
        int index4=0;
        //41-50 degrees
        int [] temp5 = new int[year];
        int index5=0;

        for (int i=0; i<year; i++){
            int number = rand.nextInt(50);//generating a random number between 0 and 50
            if(number <= 10){
                temp1[index1] = number;
                index1 = index1 + 1;
            }
            else if(number <= 20){
                temp2[index2] = number;
                index2 = index2 + 1;
            }
            else if(number <= 30){
                temp3[index3] = number;
                index3 = index3 + 1;
            }
        }

        //Print the first three temp arrays
        System.out.println("===Temp1===");
        System.out.print("[");
        for (int i=0; i<index1 ; i++){
            System.out.print(" "+temp1[i]);
        }
        System.out.print(" ]");
        System.out.println();

        System.out.println("===Temp2===");
        System.out.print("[");
        for (int i=0; i<index2 ; i++){
            System.out.print(" "+temp2[i]);
        }
        System.out.print(" ]");
        System.out.println();

        System.out.println("===Temp3===");
        System.out.print("[");
        for (int i=0; i<index1 ; i++){
            System.out.print(" "+temp3[i]);
        }
        System.out.print(" ]");
        System.out.println();
    }
}
    

    