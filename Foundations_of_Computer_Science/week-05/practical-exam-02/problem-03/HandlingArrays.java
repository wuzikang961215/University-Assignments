//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: break room 1 
//===================================
public class HandlingArrays {

    // printing the array as requested
    public static void printArray(double [] testArray) {
        System.out.print("[");
        // for loop
        for(int i = 0 ; i < testArray.length; i++){
            if(i < testArray.length-1){
                // printing "," as expected
                System.out.print(testArray[i]+",");
            }
            else{
                System.out.print(testArray[i]);
            }
        }
        System.out.println("]");
    }

    // calculating array sum
    public static double[] sumElements(double [] firstArray, double [] secondArray) {
        double [] sum = new double[firstArray.length];
        if(firstArray.length != secondArray.length){
            throw new RuntimeException("Error - Arrays different shape");
        }
        else{
            // adding the values from each array
            for(int i = 0; i<firstArray.length; i++){
                sum[i] = firstArray[i]+secondArray[i];
            }
            return sum;
        }
    }

    public static double[] sumAnyArrays(double [] firstArray, double [] secondArray) {
        // using conditions to tell from the longer array
        if(firstArray.length>= secondArray.length){
            double [] sum = new double[firstArray.length];
            int x = 0;
            for(int i = 0; i<firstArray.length; i++){
                if(x<secondArray.length){
                    // adding the values from each array
                    sum[i] = firstArray[i] + secondArray[x];
                    x++;
                }
                else{
                    // taking the missing values as zero
                    sum[i] = firstArray[i];
                }
            }
            return sum;
        }
        else{
            double [] sum = new double[secondArray.length];
            int x = 0;
            for(int i = 0; i<secondArray.length; i++){
                if(x<firstArray.length){
                    sum[i] = firstArray[x] + secondArray[i];
                    x++;
                }
                else{
                    sum[i] = secondArray[i];
                }
            }
            return sum;
        }
    }

    public static double[] maxArrays(double [] firstArray, double [] secondArray) {
        double [] max_array = new double[firstArray.length];
        if(firstArray.length != secondArray.length){
            throw new RuntimeException("Error - Arrays different shape");
        }
        else{
            for(int i = 0; i<firstArray.length; i++){
                // taking the bigger values from both arrays
                if(firstArray[i] >= secondArray[i]){
                    max_array[i] = firstArray[i];
                }
                else{
                    max_array[i] = secondArray[i];
                }
            }
            return max_array;
        }
    }


}