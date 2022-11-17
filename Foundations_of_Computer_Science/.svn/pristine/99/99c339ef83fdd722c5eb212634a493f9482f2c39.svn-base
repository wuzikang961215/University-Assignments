public class QuickSort extends MySortAlg{

    private int [] getSmaller(int [] array, int pivot){
        int smallerLength = 0;
        // get the length of the smaller array
        for(int i = 0; i < array.length; i++){
            if(array[i] < pivot)
                smallerLength++;
        }
        int [] smallerArray = new int[smallerLength];
        // put the smaller elements into array
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < pivot){
                smallerArray[index] = array[i];
                index++;
            }
        }
        return smallerArray;
    }

    private int [] getBigger(int [] array, int pivot){
        int biggerLength = 0;
        // get the length of the bigger array
        for(int i = 0; i < array.length; i++){
            if(array[i] > pivot)
                biggerLength++;
        }
        int [] biggerArray = new int[biggerLength];
        // put the bigger elements into array
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > pivot){
                biggerArray[index] = array[i];
                index++;
            }
        }
        return biggerArray;
    }

    // concatenate two arrays
    private int [] concatenate(int [] left, int [] right, int pivot){
        int [] concatenateArray = new int[left.length + right.length + 1];
        int i = 0;
        // get the elements from left
        while(i < left.length){
            concatenateArray[i] = left[i];
            i++;
        }
        // put the pivot in the middle
        concatenateArray[i] = pivot;
        i++;
        // get the elements from right
        while(i - left.length - 1 < right.length){
            concatenateArray[i] = right[i - left.length - 1];
            i++;
        }
        return concatenateArray;
    }

    // quick sort
    public int [] sort(int [] array){
        if(array.length <= 1)
            return array;
        else{
            // get the pivot
            int pivot = array[array.length-1];
            int [] biggerArray = getBigger(array, pivot);
            // recursively get the bigger array
            biggerArray = sort(biggerArray);

            int [] smallerArray = getSmaller(array, pivot);
            // recursively get the smaller array
            smallerArray = sort(smallerArray);

            return concatenate(biggerArray, smallerArray, pivot);
        }   
    }
}