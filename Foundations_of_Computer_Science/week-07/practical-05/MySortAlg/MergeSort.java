public class MergeSort extends MySortAlg{

    // get subarray of an array from index begin to index end
    private int [] getSubArray(int [] array, int begin, int end){
        int [] subArray = new int[end - begin];
        for(int i = begin; i < end; i++)
            // put the ith element in array to (i-begin)th element in sub-array
            subArray[i-begin] = array[i];
        return subArray;
    }

    // merge two sub-arrays
    private int [] mergeArray(int [] array1, int [] array2){
        int [] mergedArray = new int[array1.length + array2.length];
        int i1 = 0, i2 = 0, i = 0; // initialize 3 indexes of 3 arrays
        // get the  bigger value
        while(i1 < array1.length && i2 < array2.length){
            if(array1[i1] > array2[i2]){
                mergedArray [i] = array1[i1];
                i1++;
            }
            else{
                mergedArray [i] = array2[i2];
                i2++;
            }
            i++;
        }

        // get the value left from either
        while(i1 < array1.length){
            mergedArray[i] = array1[i1];
            i1++;
            i++;
        }
        while(i2 < array2.length){
            mergedArray[i] = array2[i2];
            i2++;
            i++;
        }

        return mergedArray;
    }

    // merge sort
    public int [] sort(int [] array){
        if(array.length == 1)
            return array;
        else{
            // get the middle of the array
            int middle = (int)Math.ceil((double)array.length/2);
            int [] firstSubArray = getSubArray(array, 0, middle);
            // divide the array recursively
            firstSubArray = sort(firstSubArray);

            int [] secondSubArray = getSubArray(array, middle, array.length);
            secondSubArray = sort(secondSubArray);
            // merge the sub-arrays
            return mergeArray(firstSubArray, secondSubArray);
        }
    }
}